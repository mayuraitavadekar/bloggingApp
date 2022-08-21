package com.example.bloggingapp.Security;

import com.example.bloggingapp.entities.User;
import com.example.bloggingapp.exceptions.ResourceNotFoundException;
import com.example.bloggingapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // loading user from database by username
        User user = this.userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User", "email", username));
        return user;
    }
}
