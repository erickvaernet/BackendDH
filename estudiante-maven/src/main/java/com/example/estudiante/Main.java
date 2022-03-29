package com.example.estudiante;

import com.example.estudiante.dao.implementacion.EstudianteDAOH2;
import com.example.estudiante.model.Estudiante;
import com.example.estudiante.service.EstudianteService;

public class Main {
    public static void main(String[] args) {

        Estudiante e1= new Estudiante();
        e1.setId(1);
        e1.setNombre("Erick");
        e1.setApellido("Vaernet");

        EstudianteService eService= new EstudianteService();
        eService.setEstudianteIDao(new EstudianteDAOH2());

        eService.guardarEstudiante(e1);

        System.out.println("asdfas");
        System.out.println(eService.buscarEstudiante(1l));


    }
}
