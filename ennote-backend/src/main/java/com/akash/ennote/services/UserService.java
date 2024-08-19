package com.akash.ennote.services;

import com.akash.ennote.dtos.UserDTO;
import com.akash.ennote.entity.User;

import java.util.List;

public interface UserService {

    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDTO getUserById(Long userId);

}
