package com.example.integradorV2.DTO;

import com.example.integradorV2.Entities.Appointment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
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
}
