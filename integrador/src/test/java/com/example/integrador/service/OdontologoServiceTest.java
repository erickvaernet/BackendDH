package com.example.integrador.service;

import com.example.integrador.domain.Domicilio;
import com.example.integrador.domain.Odontologo;
import com.example.integrador.repository.Impl.DomicilioDaoH2;
import com.example.integrador.repository.Impl.OdontologoDaoH2;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
class OdontologoServiceTest {
    public static OdontologoService odontologoService= new OdontologoService(new OdontologoDaoH2());


    @BeforeAll
    public static void cargarDataSet() {
       odontologoService.createOdontologo(new Odontologo("Erick", "Vaernet",41421));
       odontologoService.createOdontologo(new Odontologo("Pablo", "Sanchez",51421));

    }

    @Test
    void createOdontologo() {
        Odontologo o1= new Odontologo("Roco","Toledo",12413);
        o1=odontologoService.createOdontologo(o1);
        Assertions.assertNotNull(o1.getId());
        Assertions.assertTrue(o1.getId()>0);
    }

    @Test
    void delete() {
        odontologoService.delete(2);
        Assertions.assertTrue(odontologoService.get(2) == null);
    }

    @Test
    void get() {
        Odontologo d=odontologoService.createOdontologo(new Odontologo("Riko","Temperley", 12441));
        Assertions.assertNotNull(odontologoService.get(d.getId()));
    }

    @Test
    void list() {
        List<Odontologo> odontologos = odontologoService.list();
        Assertions.assertTrue(!odontologos.isEmpty());
        Assertions.assertTrue(odontologos.size() > 0);
        System.out.println(odontologos);
    }

    @Test
    void update() {
        String nombreSinActualizar="Alexis";
        Odontologo o2=odontologoService.createOdontologo(new Odontologo(nombreSinActualizar,"Vaernet",341324));
        o2.setNombre("Ian");
        odontologoService.update(o2);
        String nombreActual=odontologoService.get(o2.getId()).getNombre();
        Assertions.assertNotEquals(nombreActual,nombreSinActualizar);
    }
}