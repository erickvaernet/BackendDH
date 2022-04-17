package com.example.integradorV2.DTO;

import com.example.integradorV2.Entities.Address;
import com.example.integradorV2.Entities.Appointment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class PatientDTO {
    private Long id;
    private Integer DNI;
    private String name;
    private String lastName;
    private String email;
    private LocalDate entryDate;
    private Address address;
    private Set<Appointment> appointments;
}
