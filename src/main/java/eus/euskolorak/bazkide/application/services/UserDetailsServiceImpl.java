package eus.euskolorak.bazkide.application.services;

import eus.euskolorak.bazkide.application.exceptions.NotFoundException;
import eus.euskolorak.bazkide.domain.model.Permission;
import eus.euskolorak.bazkide.domain.model.User;
import eus.euskolorak.bazkide.domain.ports.in.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author BICUGUAL
 */
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user;

        try {
            user = userService.findById(username);
        } catch (NotFoundException e) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                getAuthorities(user));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {

        Set<String> userPermissions = user.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(Permission::getPermissionName)
                .collect(Collectors.toSet());

        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userPermissions);

        return authorities;
    }


}
