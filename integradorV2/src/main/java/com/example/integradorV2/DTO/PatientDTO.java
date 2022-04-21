package com.example.integradorV2.DTO;

import com.example.integradorV2.Entities.Address;
import com.example.integradorV2.Entities.Appointment;
import com.example.integradorV2.Entities.Role;
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
public class PatientDTO extends UserDTO{
    private Integer dni;
    private LocalDate entryDate;
    private Address address;
    private Set<Appointment> appointments;

    public PatientDTO(String username, String password, String email, Role role, String name, String lastName, String token, Integer dni, LocalDate entryDate, Address address) {
        super(username, password, email, role, name, lastName, token);
        this.dni = dni;
        this.entryDate = entryDate;
        this.address = address;
    }
}
