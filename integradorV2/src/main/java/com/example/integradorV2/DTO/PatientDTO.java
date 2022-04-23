package com.example.integradorV2.DTO;

import com.example.integradorV2.Entities.Address;
import com.example.integradorV2.Entities.Appointment;
import com.example.integradorV2.Entities.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientDTO {
    private Long id;
    private Integer dni;
    private String username;
    private String password;
    private Role role;
    private String name;
    private String lastName;
    private LocalDate entryDate;
    private Address address;
    private Set<Appointment> appointments;


    public PatientDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public PatientDTO(Integer dni, String username, String password, String name, String lastName, LocalDate entryDate, Address address) {
        this.dni = dni;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.entryDate = entryDate;
        this.address = address;
    }
}
