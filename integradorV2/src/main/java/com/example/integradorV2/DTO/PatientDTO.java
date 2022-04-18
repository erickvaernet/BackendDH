package com.example.integradorV2.DTO;

import com.example.integradorV2.Entities.Address;
import com.example.integradorV2.Entities.Appointment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
public class PatientDTO {
    private Long id;
    private Integer dni;
    private String name;
    private String lastName;
    private String email;
    private LocalDate entryDate;
    private Address address;
    private Set<Appointment> appointments;

    public PatientDTO(Integer dni, String name, String lastName, String email, LocalDate entryDate, Address address) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.entryDate = entryDate;
        this.address = address;
    }
}
