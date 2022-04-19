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
    private PatientDTO patient;
    private DentistDTO dentist;
    private LocalDateTime dateTime;

    public AppointmentDTO(PatientDTO patient, DentistDTO dentist, LocalDateTime dateTime) {
        this.patient = patient;
        this.dentist = dentist;
        this.dateTime = dateTime;
    }

    public AppointmentDTO(Long id, PatientDTO patient, DentistDTO dentist, LocalDateTime dateTime) {
        this.id = id;
        this.patient = patient;
        this.dentist = dentist;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "id=" + id +
                ", patient=" + patient +
                ", dentist=" + dentist +
                ", dateTime=" + dateTime +
                '}';
    }
}
