package com.akash.ennote.services;

import com.akash.ennote.dtos.UserDTO;
import com.akash.ennote.entity.Role;
import com.akash.ennote.entity.User;

import java.util.List;

public interface UserService {

    void updateUserRole(Long userId, String roleName);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long userId);

    User findByUsername(String username);

    void updateAccountLockStatus(Long userId, boolean lock);

    List<Role> getAllRoles();

    void updateAccountExpiryStatus(Long userId, boolean expire);

    void updateAccountEnabledStatus(Long userId, boolean enabled);

    void updateCredentialsExpiryStatus(Long userId, boolean expire);

    void updatePassword(Long userId, String password);

    void generatePasswordResetToken(String email);

    void resetPassword(String token, String newPassword);

}
