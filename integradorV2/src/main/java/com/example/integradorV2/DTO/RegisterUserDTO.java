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
public class RegisterUserDTO {
    private Long id;
    private String username;
    private String password;
    private Role role;
    private Integer licenseNumber;
    private String name;
    private String lastName;
    private String token;

    public RegisterUserDTO(String username, String password, Integer licenseNumber, String name, String lastName) {
        this.username = username;
        this.password = password;
        this.licenseNumber = licenseNumber;
        this.name = name;
        this.lastName = lastName;
    }
}
