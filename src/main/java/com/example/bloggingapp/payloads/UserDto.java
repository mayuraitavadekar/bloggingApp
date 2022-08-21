package com.example.bloggingapp.payloads;

import com.example.bloggingapp.entities.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class UserDto {
    private int id;

    @NotNull
    @Size(min = 4, message = "username must be minimum of 4 characters")
    private String name;

    @Email(message = "email is not valid")
    @NotNull(message = "email cannot be blank")
    @NotEmpty(message = "email cannot be blank")
    private String email;

    @NotNull(message = "password cannot be blank")
    @NotEmpty(message = "password cannot be blank")
    @Size(min = 3, max = 10, message = "password must be between 3-10 characters")
    private String password;

    @NotNull(message = "about info cannot be blank")
    @NotEmpty(message = "about info cannot be blank")
    private String about;

    private Set<RoleDto> roles = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
