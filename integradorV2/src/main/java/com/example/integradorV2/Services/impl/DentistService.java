package com.example.integradorV2.Services.impl;

import com.example.integradorV2.DTO.DentistDTO;
import com.example.integradorV2.DTO.RegisterUserDTO;
import com.example.integradorV2.Entities.Dentist;
import com.example.integradorV2.Entities.Role;
import com.example.integradorV2.Entities.User;
import com.example.integradorV2.Exceptions.EntityNotFoundException;
import com.example.integradorV2.Exceptions.InvalidIdException;
import com.example.integradorV2.Exceptions.NullFieldsException;
import com.example.integradorV2.Persistence.IDentistRepository;
import com.example.integradorV2.Persistence.IUserRepository;
import com.example.integradorV2.Services.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DentistService implements IDentistService {
    @Autowired
    private IDentistRepository dentistRepository;
    @Autowired
    private IUserRepository userRepository;

    /*public RegisterUserDTO save2(RegisterUserDTO registerUserDTO){
        if(registerUserDTO.getLicenseNumber()==null) throw new NullFieldsException("Licence Number Cannot be null");
        Dentist newDentist= new ObjectMapper().convertValue(registerUserDTO, Dentist.class);
        dentistRepository.save(newDentist);
        userRepository.save( new ObjectMapper().convertValue(registerUserDTO, User.class));
        return registerUserDTO;
    }*/

    @Override
    public DentistDTO save(DentistDTO dentistDTO) {
        if(dentistDTO.getLicenseNumber()==null) throw new NullFieldsException("Licence Number Cannot be null");
        dentistDTO.setRole(Role.DENTIST);
        Dentist newDentist= mapToEntity(dentistDTO);
        newDentist=dentistRepository.save(newDentist);
        return mapToDTO(newDentist);
    }


    @Override
    public DentistDTO update(Long id, DentistDTO dentistDTO) {
        DentistDTO dentistToUpdate=findById(id);
        //Comprobaciones
        if(dentistDTO==null) throw new NullFieldsException("Dentist cannot be null");
        //Asignaciones
        if(dentistDTO.getName()!=null) dentistToUpdate.setName(dentistDTO.getName());
        if(dentistDTO.getLastName()!=null) dentistToUpdate.setLastName(dentistDTO.getLastName());
        if(dentistDTO.getLicenseNumber()!=null) dentistToUpdate.setLicenseNumber(dentistDTO.getLicenseNumber());
        //Guardado
        dentistRepository.save(mapToEntity(dentistToUpdate));
        return dentistToUpdate;
    }

    @Override
    public DentistDTO findById(Long id) {
        if(id==null || id <= 0 ) throw new InvalidIdException("Dentist id cannot be 0, null or negative");
        Optional<Dentist> optionalDentist= dentistRepository.findById(id);
        return optionalDentist.map(this::mapToDTO)
                .orElseThrow(()->new EntityNotFoundException("Dentist not found"));
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
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
