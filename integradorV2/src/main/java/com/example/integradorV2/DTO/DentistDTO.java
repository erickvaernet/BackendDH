package com.example.integradorV2.DTO;

import com.example.integradorV2.Entities.Appointment;
import com.example.integradorV2.Entities.Role;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DentistDTO extends UserDTO{
    private Integer licenseNumber;
    private String name;
    private String lastName;
    private Set<Appointment> appointments;

    public DentistDTO(String username, String password, String email, Role role, String name, String lastName, String token, Integer licenseNumber, String name1, String lastName1) {
        super(username, password, email, role, name, lastName, token);
        this.licenseNumber = licenseNumber;
        this.name = name1;
        this.lastName = lastName1;
    }
}
