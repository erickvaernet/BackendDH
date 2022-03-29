package com.company.DAO.Ejemplo2.Test;
import com.company.DAO.Ejemplo1.dao.IDao;
import com.company.DAO.Ejemplo2.DAO.impl.DomicilioDAOH2;
import com.company.DAO.Ejemplo2.DAO.impl.PacienteDAOH2;
import com.company.DAO.Ejemplo2.Models.Domicilio;
import com.company.DAO.Ejemplo2.Models.Paciente;
import com.company.DAO.Ejemplo2.Services.DomicilioService;
import com.company.DAO.Ejemplo2.Services.PacienteService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MainTest {
    private static PacienteService pacienteService = new PacienteService(new PacienteDAOH2());
    private static DomicilioService domicilioService = new DomicilioService(new DomicilioDAOH2());
    private static Domicilio d1;
    private static Domicilio d2;
    private static Paciente p1;
    private static Paciente p2;

    @BeforeAll
    public static void cargarDataSet() {
        d1= new Domicilio(1l,"Belgrano", 342, "Resistencia", "Chaco");
        p1 = new Paciente(235423l,315134l, "Erick", "Vaernet", LocalDate.now(), d1);
        d2 = new Domicilio(2l,"Av 9 de Julio", 123, "Corrientes", "Corrientes");
        p2 = new Paciente(12312l,112312l,"Micaela", "Perez", LocalDate.now(), d2);
    }

    @Test
    public void agregarYBuscarDomicilioTest(){
        domicilioService.guardarDomicilio(d1);
        domicilioService.guardarDomicilio(d2);
        assertNotNull(domicilioService.buscarDomicilio(d1.getId()));
        assertNotNull(domicilioService.buscarDomicilio(d2.getId()));
    }

    @Test
    public void agregarYBuscarPacienteTest() {
        pacienteService.guardarPaciente(p1);
        pacienteService.guardarPaciente(p2);
        assertNotNull(pacienteService.buscarPaciente(p1.getId()));
        assertNotNull(pacienteService.buscarPaciente(p2.getId()));
    }

    @Test
    public void buscarTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        assertTrue(!pacientes.isEmpty());
        assertTrue(pacientes.size() > 0);
        System.out.println(pacientes);
    }

    @Test
    public void eliminarPacienteTest() {
        pacienteService.eliminarPaciente(1l);
        assertTrue(pacienteService.buscarPaciente(1l) == null);
    }


}