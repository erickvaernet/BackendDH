package com.example.integradorV2.Services.impl;

import com.example.integradorV2.DTO.PatientDTO;
import com.example.integradorV2.Entities.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceTest {
    @Autowired
    private  PatientService patientService;

    @Test
    void save() {
        PatientDTO patientDTO= new PatientDTO();
        patientDTO.setDNI(415612);
        patientDTO.setName("Erick");
        patientDTO.setLastName("Vaernet");
        patientDTO.setEmail("erick@mail.com");
        patientDTO.setEntryDate(LocalDate.now());
        patientDTO.setAddress(new Address());
        patientDTO=patientService.save(patientDTO);
        assertNotNull(patientDTO);
        assertTrue(patientDTO.getId()>0);
    }

    @Test
    void findById() {
        PatientDTO patientDTO= new PatientDTO();
        patientDTO.setLicenseNumber(142344);
        patientDTO.setName("Erick");
        patientDTO.setLastName("Vaernet");
        patientDTO=patientService.save(patientDTO);
        assertNotNull(patientDTO);
        PatientDTO dt=patientService.findById(1L);
        assertNotNull(dt);
    }

    @Test
    void update() {
        //datos
        int licenceNumber=34251;
        String name="Pablo";
        String lastName="Sanchez";

        //crear nuevo dentista y guardarlo
        PatientDTO patientDTO= new PatientDTO();
        patientDTO.setLicenseNumber(licenceNumber);
        patientDTO.setName(name);
        patientDTO.setLastName(lastName);
        patientDTO=patientService.save(patientDTO);

        //Asignar nuevo nombre
        String newName="Ricardo";
        patientDTO.setName(newName);
        //Obtenemos ID
        long id=patientDTO.getId();
        //Actualizamos
        patientService.update(id,patientDTO);

        //Verificacion
        PatientDTO dt=patientService.findById(id);
        assertEquals(dt.getName(),newName);
        assertEquals(dt.getLastName(),lastName);
        assertEquals(dt.getLicenseNumber(),licenceNumber);
    }

    @Test
    void deleteById() {
        patientService.deleteById(1L);
        PatientDTO dt=patientService.findById(1L);
        assertNull(dt);
    }

    @Test
    void findAll() {
        PatientDTO patientDTO= new PatientDTO();
        patientDTO.setLicenseNumber(7142344);
        patientDTO.setName("Erickk");
        patientDTO.setLastName("Vaaernet");
        patientService.save(patientDTO);
        List<PatientDTO> patientDTOList=patientService.findAll();
        assertNotNull(patientDTOList);
        assertTrue(patientDTOList.size()>0);
    }
}