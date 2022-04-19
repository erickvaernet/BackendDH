package com.example.integradorV2.Services.impl;

import com.example.integradorV2.DTO.PatientDTO;
import com.example.integradorV2.Entities.Patient;
import com.example.integradorV2.Exceptions.EntityNotFoundException;
import com.example.integradorV2.Exceptions.InvalidIdException;
import com.example.integradorV2.Persistence.IPatientRepository;
import com.example.integradorV2.Services.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    @Autowired
    private IPatientRepository patientRepository;

    @Override
    public PatientDTO save(PatientDTO patientDTO) {
        Patient newPatient= mapToEntity(patientDTO);
        newPatient=patientRepository.save(newPatient);
        return mapToDTO(newPatient);
    }

    @Override
    public PatientDTO update(Long id, PatientDTO patientDTO) {
        PatientDTO patientToUpdate=findById(id);
        //Comprobaciones
        if(patientDTO==null || patientToUpdate==null) return null;
        //Asignaciones
        if(patientDTO.getDni()!=null) patientToUpdate.setDni(patientDTO.getDni());
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
    public PatientDTO findById(Long id)  {
        if(id == 0) throw new InvalidIdException("Patient id cannot be 0 or null");
        Optional<Patient> patient= patientRepository.findById(id);
        return patient.map(this::mapToDTO)
                .orElseThrow(()->new EntityNotFoundException("Patient not found"));
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<PatientDTO> findAll() {
        List<PatientDTO> patientDTOList=new ArrayList<>();
        patientRepository.findAll()
                .forEach(
                        (patient)->patientDTOList.add(mapToDTO(patient))
                );
        return patientDTOList;
    }

    private PatientDTO mapToDTO(Patient patient){
        return new ObjectMapper().registerModule(new Jdk8Module())
                .registerModule(new ParameterNamesModule()).
                registerModule(new Jdk8Module()).
                registerModule(new JavaTimeModule()).convertValue(patient, PatientDTO.class);
    }
    private Patient mapToEntity(PatientDTO patientDTO){
        return new ObjectMapper()
                .registerModule(new ParameterNamesModule()).
                registerModule(new Jdk8Module()).
                registerModule(new JavaTimeModule()).convertValue(patientDTO, Patient.class);
    }
}
