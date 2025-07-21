package eus.euskolorak.bazkide.domain.ports.in;

import eus.euskolorak.bazkide.domain.model.User;
import org.springframework.stereotype.Service;

/**
 * @author BICUGUAL
 */
public interface UserService {
    
    User findById(String username);
}
