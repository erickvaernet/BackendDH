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
    public PatientService patientService;

    @Test
    void save() {
        PatientDTO patientDTO= new PatientDTO();
        patientDTO.setDNI(415612);
        patientDTO.setName("Erick");
        patientDTO.setLastName("Vaernet");
        patientDTO.setEmail("erick@mail.com");
        patientDTO.setEntryDate(LocalDate.now());
        patientDTO.setAddress(new Address("Alvear",1653));
        patientDTO=patientService.save(patientDTO);
        assertNotNull(patientDTO);
        assertTrue(patientDTO.getId()>0);
    }

    @Test
    void findById() {
        PatientDTO patientDTO= new PatientDTO();
        patientDTO.setDNI(52112);
        patientDTO.setName("Erick");
        patientDTO.setLastName("Vaernet");
        patientDTO.setEmail("erickk@mail.com");
        patientDTO.setEntryDate(LocalDate.now());
        patientDTO.setAddress(new Address("Alvear",1653));
        patientDTO=patientService.save(patientDTO);
        assertNotNull(patientDTO);
        PatientDTO dt=patientService.findById(1L);
        assertNotNull(dt);
    }

    @Test
    void update() {
        //datos
        int dni = 3211;
        String name = "Pablo";
        String lastName = "Sanchez";
        String email = "pablo@mail.com";
        LocalDate entryDate = LocalDate.now();
        Address address = new Address("Alvear",1653);

        //crear nuevo dentista y guardarlo
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setDNI(dni);
        patientDTO.setName(name);
        patientDTO.setLastName(lastName);
        patientDTO.setEmail(email);
        patientDTO.setEntryDate(entryDate);
        patientDTO.setAddress(address);
        patientDTO=patientService.save(patientDTO);

        //Asignar nuevo nombre
        String newName = "Ricardo";
        patientDTO.setName(newName);
        //Obtenemos ID
        long id = patientDTO.getId();
        //Actualizamos
        patientService.update(id,patientDTO);

        //Verificacion
        PatientDTO dt=patientService.findById(id);
        assertEquals(dt.getName(),newName);
        assertEquals(dt.getLastName(),lastName);
        assertEquals(dt.getDNI(),dni);
        assertEquals(dt.getEmail(),email);
        assertEquals(dt.getEntryDate(),entryDate);
        assertEquals(dt.getAddress().getStreet(),address.getStreet());
        assertEquals(dt.getAddress().getNumber(),address.getNumber());
    }

    @Test
    void deleteById() {
        PatientDTO patientDTO= new PatientDTO();
        patientDTO.setDNI(56112);
        patientDTO.setName("Erickkk");
        patientDTO.setLastName("Vaaernet");
        patientDTO.setEmail("eric2kk@mail.com");
        patientDTO.setEntryDate(LocalDate.now());
        patientDTO.setAddress(new Address("Alvear",133));
        PatientDTO ptWithId= patientService.save(patientDTO);
        long id= ptWithId.getId();
        patientService.deleteById(id);
        PatientDTO pt=patientService.findById(id);
        assertNull(pt);
    }

    @Test
    void findAll() {
        PatientDTO patientDTO= new PatientDTO();
        patientDTO.setDNI(561152);
        patientDTO.setName("Erkk");
        patientDTO.setLastName("Vernet");
        patientDTO.setEmail("erkk@mail.com");
        patientDTO.setEntryDate(LocalDate.now());
        patientDTO.setAddress(new Address("Alvear",173));
        patientService.save(patientDTO);
        List<PatientDTO> patientDTOList=patientService.findAll();
        assertNotNull(patientDTOList);
        assertTrue(patientDTOList.size()>0);
    }
}