package com.example.bloggingapp.services;

import com.example.bloggingapp.payloads.UserDto;
import java.util.*;
// we could have used entity here but that way we will expose our entities
// entity is only used for insertion in data
// instead of that for public use we will use Dtos as abstraction
public interface UserService {

    UserDto registerNewUser(UserDto user);

    // for normal user
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
