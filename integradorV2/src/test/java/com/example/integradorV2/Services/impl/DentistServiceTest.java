package com.example.integradorV2.Services.impl;

import com.example.integradorV2.DTO.DentistDTO;
import com.example.integradorV2.DTO.RegisterUserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DentistServiceTest {
    /*
    @Autowired
    public DentistService dentistService;


    @Test
    void save() {

        DentistDTO dentistDTO= new DentistDTO();
        dentistDTO.setLicenseNumber(124);
        dentistDTO.setName("Erick");
        dentistDTO.setLastName("Vaernet");
        dentistDTO=dentistService.save(dentistDTO);
        assertNotNull(dentistDTO);
        assertTrue(dentistDTO.getId()>0);

        RegisterUserDTO regiterUserDTO= new RegisterUserDTO("er","ddd",9786,"ricardo","falso");



    }

    @Test
    void findById() {
        DentistDTO dentistDTO= new DentistDTO();
        dentistDTO.setLicenseNumber(142344);
        dentistDTO.setName("Erick");
        dentistDTO.setLastName("Vaernet");
        dentistDTO=dentistService.save(dentistDTO);
        assertNotNull(dentistDTO);
        DentistDTO dt=dentistService.findById(1L);
        assertNotNull(dt);
    }

    @Test
    void update() {
        //datos
        int licenceNumber=34251;
        String name="Pablo";
        String lastName="Sanchez";

        //crear nuevo dentista y guardarlo
        DentistDTO dentistDTO= new DentistDTO();
        dentistDTO.setLicenseNumber(licenceNumber);
        dentistDTO.setName(name);
        dentistDTO.setLastName(lastName);
        dentistDTO=dentistService.save(dentistDTO);

        //Asignar nuevo nombre
        String newName="Ricardo";
        dentistDTO.setName(newName);
        //Obtenemos ID
        long id=dentistDTO.getId();
        //Actualizamos
        dentistService.update(id,dentistDTO);

        //Verificacion
        DentistDTO dt=dentistService.findById(id);
        assertEquals(dt.getName(),newName);
        assertEquals(dt.getLastName(),lastName);
        assertEquals(dt.getLicenseNumber(),licenceNumber);
    }

    @Test
    void deleteById() {
        dentistService.deleteById(1L);
        try {
            DentistDTO dt = dentistService.findById(1L);
        }
        catch (Exception e){
            assertTrue(e.getMessage().contains("Dentist not found"));
        }
    }

    @Test
    void findAll() {
        DentistDTO dentistDTO= new DentistDTO();
        dentistDTO.setLicenseNumber(7142344);
        dentistDTO.setName("Erickk");
        dentistDTO.setLastName("Vaaernet");
        dentistService.save(dentistDTO);
        List<DentistDTO> dentistDTOList=dentistService.findAll();
        assertNotNull(dentistDTOList);
        assertTrue(dentistDTOList.size()>0);
    }*/

}