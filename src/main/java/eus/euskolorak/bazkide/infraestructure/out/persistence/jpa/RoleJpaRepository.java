package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa;

import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author BICUGUAL
 */
public interface RoleJpaRepository extends JpaRepository<RoleEntity, String> {
}
