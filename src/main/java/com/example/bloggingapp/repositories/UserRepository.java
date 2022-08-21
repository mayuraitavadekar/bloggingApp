package com.example.bloggingapp.repositories;

import com.example.bloggingapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // for spring security
    Optional<User> findByEmail(String email);
}
