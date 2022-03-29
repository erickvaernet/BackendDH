package com.example.estudiante;

import com.example.estudiante.dao.implementacion.EstudianteDAOH2;
import com.example.estudiante.model.Estudiante;
import com.example.estudiante.service.EstudianteService;
import org.junit.Assert;
import org.junit.Test;

public class EstudianteServiceTest {
    private EstudianteService estudianteService=new EstudianteService(new EstudianteDAOH2());

    @Test
    public void guardarEstudiante(){
        Estudiante eAux= new Estudiante(1251,"Erick","Vaernet");
        Estudiante eAux2= estudianteService.guardarEstudiante(eAux);
        Assert.assertEquals(eAux,eAux2);
    }

    @Test
    public void listarEstudiantes(){
        estudianteService.guardarEstudiante(new Estudiante(3231,"Rick","Sanchez"));
        estudianteService.guardarEstudiante(new Estudiante(325,"Ian","Vaernet"));
        Assert.assertTrue(estudianteService.buscarTodos().size()>0);
    }
}
