package eus.euskolorak.bazkide.domain.ports.in;

import eus.euskolorak.bazkide.domain.model.Membership;

import java.util.List;

/**
 * @author BICUGUAL
 */
public interface MembershipService {

    List<Membership> findMembershipAll();

    Membership findMembershipById(Long idMembership);

    Membership createMembership(Membership membership);

    Membership updateMembership(Membership membership);

    void deleteMembership(Long idMembership);

    boolean isOrphanMembership(Long idMembership);
}
