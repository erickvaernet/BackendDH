package com.example.integradorV2.Controllers;

import com.example.integradorV2.DTO.*;
import com.example.integradorV2.Services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
