package com.company.Services;

import com.company.DAO.DBH2Singleton;
import com.company.DAO.OdontologoDAOH2;
import com.company.Models.Odontologo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {
    private final OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2(DBH2Singleton.getInMemoryConnection()));


    @Test
    void guardarOdontologo() {
        Odontologo oaux= new Odontologo(7777,"Ayudin","Auxiliar");
        assertEquals(oaux,odontologoService.guardarOdontologo(oaux));
    }

    @Test
    void buscarOdontologo() {
        Odontologo oaux2= new Odontologo(72,"Ayudin2","Auxiliar2");
        int idaux2=odontologoService.guardarOdontologo(oaux2).getId();
        assertEquals(oaux2,odontologoService.buscarOdontologo(idaux2));
    }

    @Test
    void eliminarOdontologo() {
        Odontologo oaux3= new Odontologo(73,"Ayudin3","Auxiliar3");
        int idaux3=odontologoService.guardarOdontologo(oaux3).getId();
        odontologoService.eliminarOdontologo(idaux3);
        assertNull(odontologoService.buscarOdontologo(idaux3));
    }


    @org.junit.jupiter.api.Test
    void listarOdontologos() {
        Odontologo o1= new Odontologo(1924,"Erick","Vaernet");
        Odontologo o2= new Odontologo(5242,"Juan","Farre");
        Odontologo o3= new Odontologo(4689,"Ivan","Rodriguez");
        odontologoService.guardarOdontologo(o1);
        odontologoService.guardarOdontologo(o2);
        odontologoService.guardarOdontologo(o3);

        assertTrue(odontologoService.listarOdontologos().size()>0);
    }
}