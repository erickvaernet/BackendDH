package com.example.integradorV2.Persistence;

import com.example.integradorV2.Entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDentistRepository extends JpaRepository<Dentist,Long> {
}
