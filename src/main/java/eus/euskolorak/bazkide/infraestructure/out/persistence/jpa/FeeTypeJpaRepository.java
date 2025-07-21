package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa;

import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities.FeeTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author BICUGUAL
 */
public interface FeeTypeJpaRepository extends JpaRepository<FeeTypeEntity, Long> {
}
