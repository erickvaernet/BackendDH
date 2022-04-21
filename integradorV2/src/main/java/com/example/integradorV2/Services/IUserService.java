package com.example.integradorV2.Services;

import com.example.integradorV2.Entities.Role;
import com.example.integradorV2.Entities.User;

public interface IUserService {

    User login(String username, String password);
    boolean changePssword(String username, String password, String newPassword);
    String getJWTToken(String username, Role role);
}
