package com.example.integradorV2.Services;

import com.example.integradorV2.DTO.UserDTO;
import com.example.integradorV2.Entities.Role;
import com.example.integradorV2.Entities.User;

public interface IUserService {

    UserDTO login(String username, String password);
    boolean changePassword(String username, String password, String newPassword);
    String getJWTToken(String username, Role role);
    UserDTO save(UserDTO userDTO);
}
