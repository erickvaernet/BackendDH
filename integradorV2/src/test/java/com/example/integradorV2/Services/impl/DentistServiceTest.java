package com.example.integradorV2.Services.impl;

import com.example.integradorV2.DTO.DentistDTO;
import com.example.integradorV2.Entities.Dentist;
import com.example.integradorV2.Services.impl.DentistService;
import org.apache.catalina.Manager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.DriverManager;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DentistServiceTest {
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
    }

    @Test
    void update() {
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
    void deleteById() {
        dentistService.deleteById(1L);
        DentistDTO dt=dentistService.findById(1L);
        assertNull(dt);
    }

    @Test
    void findAll() {
        DentistDTO dentistDTO= new DentistDTO();
        dentistDTO.setLicenseNumber(7142344);
        dentistDTO.setName("Erickk");
        dentistDTO.setLastName("Vaaernet");
        dentistDTO=dentistService.save(dentistDTO);
        List<DentistDTO> dentistDTOList=dentistService.findAll();
        assertNotNull(dentistDTOList);
        assertTrue(dentistDTOList.size()>0);
    }

}