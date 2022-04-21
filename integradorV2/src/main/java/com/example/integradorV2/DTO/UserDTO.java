package com.example.integradorV2.DTO;

import com.example.integradorV2.Entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Role role;
    private String name;
    private String lastName;
    private String token;

    public UserDTO(String username, String password, String email, Role role, String name, String lastName, String token) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.name = name;
        this.lastName = lastName;
        this.token = token;
    }
}
