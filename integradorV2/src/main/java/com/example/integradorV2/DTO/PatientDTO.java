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
}
