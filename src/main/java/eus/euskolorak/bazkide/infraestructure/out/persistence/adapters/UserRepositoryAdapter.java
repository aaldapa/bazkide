package eus.euskolorak.bazkide.infraestructure.out.persistence.adapters;

import eus.euskolorak.bazkide.domain.model.User;
import eus.euskolorak.bazkide.domain.ports.out.UserRepository;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.UserJpaRepository;
import eus.euskolorak.bazkide.infraestructure.out.persistence.jpa.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author BICUGUAL
 */
@Slf4j
@RequiredArgsConstructor
@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository repository;
    private final UserMapper mapper;

    @Override
    public Optional<User> findById(String username) {
        return repository.findById(username).map(mapper::toModel);
    }
}
