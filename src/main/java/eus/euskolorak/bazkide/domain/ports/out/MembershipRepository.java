package eus.euskolorak.bazkide.domain.ports.out;

import eus.euskolorak.bazkide.domain.model.Membership;

import java.util.List;
import java.util.Optional;

/**
 * @author BICUGUAL
 */
public interface MembershipRepository {

    List<Membership> findAll();

    Optional<Membership> findById(Long idMembership);

    Membership save(Membership membership);

    boolean isOrphanMembership(Long idMembership);

    void deleteById(Long idMembership);
}
