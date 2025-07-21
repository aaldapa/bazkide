package eus.euskolorak.bazkide.application.services;

import eus.euskolorak.bazkide.application.exceptions.NotFoundException;
import eus.euskolorak.bazkide.application.utils.Messages;
import eus.euskolorak.bazkide.domain.model.User;
import eus.euskolorak.bazkide.domain.ports.in.UserService;
import eus.euskolorak.bazkide.domain.ports.out.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author BICUGUAL
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private static final String ERROR_NOT_FOUND = "error.resource.not.found";

    private final Messages messages;
    private final UserRepository repository;

    @Override
    public User findById(String username) {
        return repository.findById(username)
                .orElseThrow(() ->
                        new NotFoundException(messages.get(ERROR_NOT_FOUND,new Object[]{ User.class.getSimpleName(), username })));
    }
}
