package com.example.integradorV2.Services.impl;

import com.example.integradorV2.DTO.DentistDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DentistServiceTest {

    @Autowired
    public DentistService dentistService;

    @Test
    void save() {
        DentistDTO dentistDTO= new DentistDTO("SRDentista","srdentista","Dentista1","apellidod1",44923);
        dentistDTO=dentistService.save(dentistDTO);
        assertNotNull(dentistDTO);
        assertTrue(dentistDTO.getId()>0);
    }

    @Test
    void findById() {
        DentistDTO dentistDTO= new DentistDTO("Rick","Sanchez","Rick","Sanchez",513);
        dentistDTO=dentistService.save(dentistDTO);
        assertNotNull(dentistDTO);
        DentistDTO dt=dentistService.findById(dentistDTO.getId());
        assertNotNull(dt);
    }

    @Test
    void update() {
        //datos
        String name="Erick22";
        String lastName="Sanchez";
        int licenceNumber=33681;

        //crear nuevo dentista y guardarlo
        DentistDTO dentistDTO= new DentistDTO("Erick2","Vaernet2",name,lastName,licenceNumber);
        dentistDTO=dentistService.save(dentistDTO);

        //Asignar nuevo nombre
        String newName="PABLO";
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
        DentistDTO dt=null;
        try {
            dt = dentistService.findById(1L);
        }
        catch (Exception e){
            assertTrue(e.getMessage().contains("Dentist not found"));
        }
        assertTrue(dt==null);
    }

    @Test
    void findAll() {
        DentistDTO dentistDTO= new DentistDTO("Daniela","Sanchez","Daniela","Sanchezz",1113);
        dentistService.save(dentistDTO);
        List<DentistDTO> dentistDTOList=dentistService.findAll();
        assertNotNull(dentistDTOList);
        assertTrue(dentistDTOList.size()>0);
    }

}