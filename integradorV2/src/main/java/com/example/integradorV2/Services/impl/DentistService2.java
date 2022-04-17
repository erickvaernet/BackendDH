package com.example.integradorV2.Services.impl;

import com.example.integradorV2.DTO.DentistDTO;
import com.example.integradorV2.Entities.Dentist;
import com.example.integradorV2.Persistence.IDentistRepository;
import com.example.integradorV2.Services.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DentistService2 implements IDentistService {
    @Autowired
    private IDentistRepository dentistRepository;

    @Override
    public DentistDTO save(DentistDTO dentistDTO) {
        Dentist newDentist= mapToEntity(dentistDTO);
        newDentist=dentistRepository.save(newDentist);
        return mapToDTO(newDentist);
    }

    @Override
    public DentistDTO update(Long id, DentistDTO dentistDTO) {
        DentistDTO dentistToUpdate=findById(id);
        //Comprobaciones
        if(dentistDTO==null || dentistToUpdate==null) return null;
        //Asignaciones
        if(dentistToUpdate.getName()!=null) dentistToUpdate.setName(dentistDTO.getName());
        if(dentistToUpdate.getLastName()!=null) dentistToUpdate.setLastName(dentistDTO.getLastName());
        if(dentistToUpdate.getLicenseNumber()!=null) dentistToUpdate.setLicenseNumber(dentistDTO.getLicenseNumber());
        //Guardado
        dentistRepository.save(mapToEntity(dentistToUpdate));
        return dentistToUpdate;
    }

    @Override
    public DentistDTO findById(Long id) {
        Optional<Dentist> optionalDentist= dentistRepository.findById(id);
        return optionalDentist.map(this::mapToDTO).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        dentistRepository.deleteById(id);
    }

    @Override
    public List<DentistDTO> findAll() {
        List<DentistDTO> dentistDTOList=new ArrayList<>();
        dentistRepository.findAll()
                .forEach(
                        (dentist)->dentistDTOList.add(mapToDTO( dentist ))
                );
        return dentistDTOList;
    }

    //Mappers
    private DentistDTO mapToDTO(Dentist dentist){
        return new ObjectMapper().convertValue(dentist, DentistDTO.class);
    }
    private Dentist mapToEntity(DentistDTO dentistDto){
        return new ObjectMapper().convertValue(dentistDto, Dentist.class);
    }
}
