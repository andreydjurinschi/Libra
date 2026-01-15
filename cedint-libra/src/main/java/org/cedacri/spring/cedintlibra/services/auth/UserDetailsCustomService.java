package org.cedacri.spring.cedintlibra.services.auth;

import org.cedacri.spring.cedintlibra.entity.User;
import org.cedacri.spring.cedintlibra.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsCustomService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsCustomService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLoginWithType(username);
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(user.getUserType().getUserType())
                .build();
    }
}
