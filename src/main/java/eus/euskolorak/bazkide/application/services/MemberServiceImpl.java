package eus.euskolorak.bazkide.application.services;

import eus.euskolorak.bazkide.application.exceptions.NotFoundException;
import eus.euskolorak.bazkide.application.utils.Messages;
import eus.euskolorak.bazkide.domain.model.Member;
import eus.euskolorak.bazkide.domain.ports.in.MemberService;
import eus.euskolorak.bazkide.domain.ports.in.MembershipService;
import eus.euskolorak.bazkide.domain.ports.out.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * @author BICUGUAL
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final Messages messages;
    private final MemberRepository memberRepository;
    private final MembershipService membershipService;

    @Override
    public List<Member> findMembers(String searchType, String filterValue) {

        if ("memberNumber".equalsIgnoreCase(searchType)) {
            return memberRepository.findByMemberNumber(Long.valueOf(filterValue))
                    .map(List::of)
                    .orElseGet(Collections::emptyList);
        } else if ("dni".equalsIgnoreCase(searchType)) {
            return memberRepository.findByDni(filterValue);
        } else if (null != filterValue) {
            return memberRepository.findByNameOrSurname1(filterValue);
        }

        return List.of();
    }

    @Override
    public Member findMembersById(Long idMember) {
        return memberRepository.findById(idMember)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Member createMember(Member member){
        member.setMemberNumber(getNextMemberNumber());
        return memberRepository.save(member);
    }

    @Override
    public Long getNextMemberNumber() {
        return memberRepository.findMaxMemberNumber().orElse( Long.valueOf(0)) + 1;
    }

    @Transactional
    @Override
    public Member updateMember(Member member) {

        validateUpdateMember(member);

        Member memberBD = this.findMembersById(member.getIdMember());
        Long idMembership = memberBD.getIdMembership();

        member.setMemberNumber(memberBD.getMemberNumber());
        member.setStartDate(memberBD.getStartDate());

        member = memberRepository.save(member);

        deleteMembershipIfIsOrphan(idMembership);

        return member;
    }

    @Transactional
    @Override
    public Member unregisterMember(Long idMember) {

        Member member = findMembersById(idMember);
        Long idMembership = member.getIdMembership();

        member.setEndDate(LocalDate.now());
        member.setIdMembership(null);
        member.setContactData(null);
        memberRepository.save(member);

        deleteMembershipIfIsOrphan(idMembership);

        return member;
    }

    @Override
    public void deleteMemberById(Long idMember) {
        memberRepository.deleteById(idMember);
    }


    void validateUpdateMember(Member member){

        if( null == member.getIdMembership()){
            throw new IllegalArgumentException(
                    messages.get("error.validation.required.field", new Object[] {"Id de afiliación"}));
        } else{
            membershipService.findMembershipById(member.getIdMembership());
        }
    }

    void deleteMembershipIfIsOrphan(Long idMembership){
        if (null != idMembership && membershipService.isOrphanMembership(idMembership)) {
            membershipService.deleteMembership(idMembership);
        }
    }
}
