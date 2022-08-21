package com.example.bloggingapp;

import com.example.bloggingapp.config.AppConstants;
import com.example.bloggingapp.entities.Role;
import com.example.bloggingapp.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@SpringBootApplication
@Configuration
public class BloggingAppApplication implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(BloggingAppApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
        // if user is running application for first time create roles in roles table




        Role role1 = new Role();
        role1.setRoleId(AppConstants.ADMIN_USER_ROLE);
        role1.setRoleName("ROLE_ADMIN");

        Role role2 = new Role();
        role2.setRoleId(AppConstants.NORMAL_USER_ROLE);
        role2.setRoleName("ROLE_USER");

        List<Role> roles = List.of(role1, role2);

        List<Role> result = this.roleRepository.saveAll(roles);

        // print created role
        result.forEach(role -> System.out.println(role.getRoleName()));

        // create new roles if not present in DB
        // otherwise will not create new roles
        // this is because roleIds are fixed set and it will keep updating existing roleIds.
    }
}
