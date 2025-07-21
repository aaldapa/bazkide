package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa;

import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author BICUGUAL
 */
public interface PermissionJpaRepository extends JpaRepository<PermissionEntity, String> {
}
