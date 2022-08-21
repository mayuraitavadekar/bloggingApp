package com.example.bloggingapp.repositories;

import com.example.bloggingapp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
