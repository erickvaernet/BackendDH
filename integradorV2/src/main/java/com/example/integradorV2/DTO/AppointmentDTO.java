package com.example.integradorV2.DTO;

import com.example.integradorV2.Entities.Dentist;
import com.example.integradorV2.Entities.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class AppointmentDTO {
    private Long id;
    private Patient patient;
    private Dentist dentist;
    private LocalDateTime dateTime;

    public AppointmentDTO(Patient patient, Dentist dentist, LocalDateTime dateTime) {
        this.patient = patient;
        this.dentist = dentist;
        this.dateTime = dateTime;
    }
}
