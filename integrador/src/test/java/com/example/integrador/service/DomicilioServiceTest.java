package com.example.integrador.service;

import com.example.integrador.domain.Domicilio;
import com.example.integrador.repository.Impl.DomicilioDaoH2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DomicilioServiceTest {
    public static DomicilioService domicilioService= new DomicilioService(new DomicilioDaoH2());


    @BeforeAll
    public static void cargarDataSet() {
        domicilioService.createDomicilio(new Domicilio("Av Belgrano", 32413, "Resistencia", "Chaco"));
        domicilioService.createDomicilio(new Domicilio("Av Wilde", 1123, "Resistencia", "Chaco"));
    }

    @Test
    void createDomicilio() {
        Domicilio dom= new Domicilio("Rivera",123,"Resistencia","Chaco");
        dom=domicilioService.createDomicilio(dom);
        Assertions.assertNotNull(dom.getId());
        Assertions.assertTrue(dom.getId()>0);
    }

    @Test
    void update() {
        String calleSinActualizar="Rivera";
        Domicilio dom= domicilioService.createDomicilio(new Domicilio(calleSinActualizar,123,"Resistencia","Chaco"));
        dom.setCalle("Misionero Klein");
        domicilioService.update(dom);
        String calleActual=domicilioService.get(dom.getId()).getCalle();
        Assertions.assertNotEquals(calleActual,calleSinActualizar);
    }

    @Test
    void delete() {
        domicilioService.delete(2);
        Assertions.assertTrue(domicilioService.get(2) == null);
    }

    @Test
    void get() {
        Domicilio d=domicilioService.createDomicilio(new Domicilio("Calle", 123, "Temperley", "Buenos Aires"));
        Assertions.assertNotNull(domicilioService.get(d.getId()));
    }


    @Test
    void list() {
        List<Domicilio> domicilios = domicilioService.list();
        Assertions.assertTrue(!domicilios.isEmpty());
        Assertions.assertTrue(domicilios.size() > 0);
        System.out.println(domicilios);
    }


    @Test
    void deleteFromTo(){

        Domicilio d1= domicilioService.createDomicilio(new Domicilio("Av Belgrano", 32413, "Resistencia", "Chaco"));
        Domicilio d2= domicilioService.createDomicilio(new Domicilio("Av Galo", 32413, "Resistencia", "Chaco"));
        Domicilio d3=domicilioService.createDomicilio(new Domicilio("Av Wilde", 1123, "Resistencia", "Chaco"));

        domicilioService.deleteFromTo(d1.getId(),d3.getId());
        Assertions.assertNull(domicilioService.get(d1.getId()));
        Assertions.assertNull(domicilioService.get(d2.getId()));
        Assertions.assertNull(domicilioService.get(d3.getId()));
    }
}