package com.example.integrador.service;

import com.example.integrador.domain.Domicilio;
import com.example.integrador.domain.Paciente;
import com.example.integrador.repository.Impl.DomicilioDaoH2;
import com.example.integrador.repository.Impl.PacienteDaoH2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {

    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
    private DomicilioService domicilioService= new DomicilioService(new DomicilioDaoH2());

    @Test
    void createPaciente() {
        Domicilio d3= domicilioService.createDomicilio(new Domicilio("Av Belgrano", 31413, "Resistencia", "Chaco"));
        Paciente p1 = pacienteService.createPaciente(new Paciente("Roco","Sanchez","oomail@mail.com",832151, LocalDate.now(),d3));
        Assertions.assertNotNull(p1.getId());
        Assertions.assertTrue(p1.getId()>0);
    }

    @Test
    void update() {
        String nombreSinActualizar= "Pablo";
        Domicilio d4= domicilioService.createDomicilio(new Domicilio("Av Belgrano", 3113, "Resistencia", "Chaco"));
        Paciente p2 = pacienteService.createPaciente(new Paciente(nombreSinActualizar,"Mendiaz","menmail@mail.com",4312151, LocalDate.now(),d4));
        p2.setNombre("Pedro");
        pacienteService.update(p2);
        String nombreActualizado= pacienteService.get(p2.getId()).getNombre();
        Assertions.assertNotEquals(nombreSinActualizar,nombreActualizado);
    }

    @Test
    void get() {
        Domicilio d5= domicilioService.createDomicilio(new Domicilio("Av Belgrano", 31413, "Resistencia", "Chaco"));
        Paciente p3 = pacienteService.createPaciente(new Paciente("Roco","Sanchez","oomail@mail.com",832151, LocalDate.now(),d5));
        Assertions.assertNotNull(pacienteService.get(p3.getId()));
    }

    @Test
    void delete() {
        Domicilio d6= domicilioService.createDomicilio(new Domicilio("Av Belgrano", 31413, "Resistencia", "Chaco"));
        Paciente p4 = pacienteService.createPaciente(new Paciente("Roco","Sanchez","oomail@mail.com",832151, LocalDate.now(),d6));
        pacienteService.delete(p4.getId());
        Assertions.assertNull(pacienteService.get(p4.getId()));
    }

    @Test
    void list() {
        Domicilio d1= domicilioService.createDomicilio(new Domicilio("Av Belgrano", 32413, "Resistencia", "Chaco"));
        Domicilio d2=domicilioService.createDomicilio(new Domicilio("Av Wilde", 1123, "Resistencia", "Chaco"));
        pacienteService.createPaciente(new Paciente("Erick","Vaernet","email@mail.com",3773333, LocalDate.now(),d1));
        pacienteService.createPaciente(new Paciente("Ian","Pochon","poail@mail.com",4723763, LocalDate.now(),d2));
        Assertions.assertNotNull(pacienteService.list());
        Assertions.assertTrue(pacienteService.list().size()>0);
    }
}