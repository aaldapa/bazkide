package eus.euskolorak.bazkide.domain.ports.in;

import eus.euskolorak.bazkide.domain.model.Member;

import java.util.List;

/**
 * @author BICUGUAL
 */
public interface MemberService {

    List<Member> findMembers(String searchType, String filterValue);

    Member findMembersById(Long idMember);

    Member createMember(Member member);

    Long getNextMemberNumber();

    Member updateMember(Member member);

    Member unregisterMember(Long idMember);

    void deleteMemberById(Long idMember);
    
}
