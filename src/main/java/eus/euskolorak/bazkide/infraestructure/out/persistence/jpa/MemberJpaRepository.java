package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa;

import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author BICUGUAL
 */
public interface MemberJpaRepository extends JpaRepository<MemberEntity, Long> {

    @Query(""" 
             SELECT m FROM MemberEntity m 
             WHERE UPPER(m.name) LIKE CONCAT('%', UPPER(:term), '%')
                OR UPPER(m.surname1) LIKE CONCAT('%', UPPER(:term), '%')                               
                OR UPPER(m.surname2) LIKE CONCAT('%', UPPER(:term), '%')
             ORDER BY m.memberNumber ASC
            """
    )
    List<MemberEntity> findMembersByTerm(String term);

    List<MemberEntity> findByDniContainingIgnoreCase(String dni);

    Optional<MemberEntity> findByMemberNumber(Long memberNumber);

    @Query("""
            SELECT max(m.memberNumber) FROM MemberEntity m
            """)
    Optional<Long> findMaxMemberNumber();
}
