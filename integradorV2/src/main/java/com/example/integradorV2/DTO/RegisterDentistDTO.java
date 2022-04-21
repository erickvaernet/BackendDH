package com.example.integradorV2.DTO;


import com.example.integradorV2.Entities.Role;
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
public class RegisterDentistDTO extends UserDTO{
    private Integer licenseNumber;
    public RegisterDentistDTO(Long id, String username, Role role, String name, String lastName, String token, Integer licenseNumber) {
        super(id, username,  role, name, lastName, token);
        this.licenseNumber = licenseNumber;
    }
    public RegisterDentistDTO(String username,  String name, String lastName, Integer licenseNumber) {
        super(username, name, lastName);
        this.licenseNumber = licenseNumber;
    }
}
