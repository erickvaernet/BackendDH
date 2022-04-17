package com.example.integradorV2.Services.impl;

import com.example.integradorV2.DTO.DentistDTO;
import com.example.integradorV2.DTO.PatientDTO;
import com.example.integradorV2.Entities.Dentist;
import com.example.integradorV2.Entities.Patient;
import com.example.integradorV2.Persistence.IPatientRepository;
import com.example.integradorV2.Services.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PatientService implements IPatientService {
    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public PatientDTO save(PatientDTO patientDTO) {
    }

    @Override
    public PatientDTO update(Long id, PatientDTO obj) {
        return null;
    }

    @Override
    public PatientDTO findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<PatientDTO> findAll() {
        return null;
    }

    private DentistDTO mapToDTO(Dentist dentist){
        return new ObjectMapper().convertValue(dentist, DentistDTO.class);
    }
    private Dentist mapToEntity(DentistDTO dentistDto){
        return new ObjectMapper().convertValue(dentistDto, Dentist.class);
    }
}
