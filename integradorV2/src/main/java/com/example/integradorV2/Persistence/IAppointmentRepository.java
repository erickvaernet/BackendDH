package com.example.integradorV2.Persistence;

import com.example.integradorV2.Entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAppointmentRepository extends JpaRepository<Appointment,Long> {
    public List<Appointment> findByDentistId(long dentistId);
    public List<Appointment> findByPatientId(long patientId);
}
