package com.example.integradorV2.DTO;

import com.example.integradorV2.Entities.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class DentistDTO {
    private Long id;
    private Integer licenseNumber;
    private String name;
    private String lastName;
    private List<Appointment> appointments;

}
