package com.example.integradorV2.Controllers;

import com.example.integradorV2.DTO.*;
import com.example.integradorV2.Entities.Dentist;
import com.example.integradorV2.Entities.User;
import com.example.integradorV2.Services.IUserService;
import com.example.integradorV2.Services.impl.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDTO requestData) {
        UserDTO userDto = userService.login(requestData.getUsername(), requestData.getPassword());
        return ResponseEntity.ok(userDto);
    }





}
