package com.example.integradorV2.DTO;

import com.example.integradorV2.Entities.Appointment;
import com.example.integradorV2.Entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistDTO {
    private Long id;
    private String username;
    private String password;
    private Role role;
    private String name;
    private String lastName;
    private Integer licenseNumber;
    private Set<Appointment> appointments;

    public DentistDTO(String username, String password, String name, String lastName, Integer licenseNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.licenseNumber = licenseNumber;
    }
}
