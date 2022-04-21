package com.example.integradorV2.DTO;

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
public class DentistListDTO {
    public Long id;
    public int licenseNumber;
    public String fullName;

    public DentistListDTO(Long id, int licenseNumber, String fullName) {
        this.id = id;
        this.licenseNumber = licenseNumber;
        this.fullName = fullName;
    }
}
