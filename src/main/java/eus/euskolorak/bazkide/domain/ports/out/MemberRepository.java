package eus.euskolorak.bazkide.domain.ports.out;

import eus.euskolorak.bazkide.domain.model.Member;

import java.util.List;
import java.util.Optional;

/**
 * @author BICUGUAL
 */
public interface MemberRepository {

    List<Member> findByNameOrSurname1(String term);
    Optional<Member> findById(Long idMember);
    Optional<Member> findByMemberNumber(Long memberNumber);
    List<Member> findByDni (String dni);
    Member save(Member member);
    Optional<Long> findMaxMemberNumber();
    void deleteById(Long idMember);
}
