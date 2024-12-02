package com.example.userservicenov24.security.services;

import com.example.userservicenov24.models.User;
import com.example.userservicenov24.repos.UserRepo;
import com.example.userservicenov24.security.models.CustomUserDetails;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@JsonDeserialize
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepo userRepository;
    public CustomUserDetailsService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User with email: " + username + " doesn't exist");
        }
        return new CustomUserDetails(optionalUser.get());
    }
}
