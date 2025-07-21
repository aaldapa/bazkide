package eus.euskolorak.bazkide.domain.ports.out;

import eus.euskolorak.bazkide.domain.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author BICUGUAL
 */
public interface UserRepository {

    @Transactional
    Optional<User> findById(String username);

}
