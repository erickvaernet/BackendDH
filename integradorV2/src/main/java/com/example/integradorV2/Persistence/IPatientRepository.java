package com.example.integradorV2.Persistence;

import com.example.integradorV2.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient,Long> {
}
