package com.example.integradorV2.DTO;

import com.example.integradorV2.Entities.Appointment;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DentistDTO {
    private Long id;
    private Integer licenseNumber;
    private String name;
    private String lastName;
    private Set<Appointment> appointments;

    public DentistDTO(Integer licenseNumber, String name, String lastName) {
        this.licenseNumber = licenseNumber;
        this.name = name;
        this.lastName = lastName;
    }
}
