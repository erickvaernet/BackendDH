package com.example.integradorV2.Services;

import com.example.integradorV2.DTO.AppointmentDTO;

import java.util.List;

public interface IAppointmentService extends ICRUDService<AppointmentDTO>{

    List<AppointmentDTO> findByDentistId(long dentistId);
    List<AppointmentDTO> findByPatientId(long patientId);
}
