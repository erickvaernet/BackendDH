package com.example.integradorV2.Persistence;

import com.example.integradorV2.Entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment,Long> {
}