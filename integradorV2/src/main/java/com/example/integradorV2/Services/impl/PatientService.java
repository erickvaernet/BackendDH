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
        Patient newPatient= mapToEntity(patientDTO);
        patientRepository.save(newPatient);
        return mapToDTO(newPatient);
    }

    @Override
    public PatientDTO update(Long id, PatientDTO patientDTO) {
        PatientDTO patientToUpdate=findById(id);
        //Comprobaciones
        if(patientDTO==null || patientToUpdate==null) return null;
        //Asignaciones
        if(patientDTO.getDNI()!=null) patientToUpdate.setDNI(patientDTO.getDNI());
        if(patientDTO.getName()!=null) patientToUpdate.setName(patientDTO.getName());
        if(patientDTO.getLastName()!=null) patientToUpdate.setLastName(patientDTO.getLastName());
        if(patientDTO.getEmail()!=null) patientToUpdate.setEmail(patientDTO.getEmail());
        if(patientDTO.getEntryDate()!=null) patientToUpdate.setEntryDate(patientDTO.getEntryDate());
        if(patientDTO.getAddress()!=null) patientToUpdate.setAddress(patientDTO.getAddress());
        //Guardado
        patientRepository.save(mapToEntity(patientToUpdate));
        return patientToUpdate;
    }

    @Override
    public PatientDTO findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientDTO> findAll() {
        return null;
    }

    private PatientDTO mapToDTO(Patient patient){
        return new ObjectMapper().convertValue(patient, PatientDTO.class);
    }
    private Patient mapToEntity(PatientDTO patientDTO){
        return new ObjectMapper().convertValue(patientDTO, Patient.class);
    }
}
