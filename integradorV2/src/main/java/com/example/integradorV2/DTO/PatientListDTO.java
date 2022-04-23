package com.example.integradorV2.DTO;

import com.example.integradorV2.Entities.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientListDTO {
    private Long id;
    private Integer dni;
    private String fullName;
    private Address address;

    public PatientListDTO(Long id, Integer dni, String fullName, Address address) {
        this.id = id;
        this.dni = dni;
        this.fullName = fullName;
        this.address = address;
    }
}
