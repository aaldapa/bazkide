package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa;

import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities.MembershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author BICUGUAL
 */
public interface MembershipJpaRepository extends JpaRepository<MembershipEntity, Long> {

    @Query("""
            SELECT SIZE(ms.members) FROM MembershipEntity ms WHERE ms.idMembership = :idMembership
            """ )
    Long countMembersInMembership(Long idMembership);

}
