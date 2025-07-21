package eus.euskolorak.bazkide.application.services;

import eus.euskolorak.bazkide.application.exceptions.NotFoundException;
import eus.euskolorak.bazkide.application.utils.Messages;
import eus.euskolorak.bazkide.domain.model.Membership;
import eus.euskolorak.bazkide.domain.ports.in.MembershipService;
import eus.euskolorak.bazkide.domain.ports.out.MembershipRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author BICUGUAL
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MembershipServiceImpl implements MembershipService {

    private final Messages messages;

    private final MembershipRepository membershipRepository;

    @Override
    public List<Membership> findMembershipAll() {
        return membershipRepository.findAll();
    }

    @Transactional
    @Override
    public Membership findMembershipById(Long idMembership) {
        return membershipRepository.findById(idMembership)
                .orElseThrow(() -> new NotFoundException(messages.get("error.resource.not.found", new Object[]{Membership.class.getSimpleName(), idMembership})));

    }

    @Transactional
    @Override
    public Membership createMembership(Membership membership) {

        if (null == membership.getMembers() || membership.getMembers().isEmpty()) {
            throw new IllegalArgumentException(messages.get("error.validation.no.members"));
        }

        return membershipRepository.save(membership);
    }

    @Transactional
    @Override
    public Membership updateMembership(Membership membership) {

        //No se modifican los members
        membership.setMembers(findMembershipById(membership.getIdMembership()).getMembers());

        return membershipRepository.save(membership);
    }

    @Override
    public void deleteMembership(Long idMembership) {
        membershipRepository.deleteById(idMembership);
    }

    @Override
    public boolean isOrphanMembership(Long idMembership) {
        return membershipRepository.isOrphanMembership(idMembership);
    }
}
