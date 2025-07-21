package eus.euskolorak.bazkide.infraestructure.out.persistence.jpa;

import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author BICUGUAL
 */
public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
}
