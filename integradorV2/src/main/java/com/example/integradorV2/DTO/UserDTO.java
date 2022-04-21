package com.example.integradorV2.DTO;

import com.example.integradorV2.Entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Role role;
    private String name;
    private String lastName;
    private String token;

    public UserDTO(String username, String name, String lastName) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;

    }
}