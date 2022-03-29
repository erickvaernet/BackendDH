package com.company.DAO.Ejemplo1;

import com.company.DAO.Ejemplo1.dao.IDao;
import com.company.DAO.Ejemplo1.dao.implementacion.EstudianteDAOH2;
import com.company.DAO.Ejemplo1.model.Estudiante;
import com.company.DAO.Ejemplo1.service.EstudianteService;

public class Main {
    public static void main(String[] args) {

        Estudiante e1= new Estudiante();
        e1.setId(1);
        e1.setNombre("Erick");
        e1.setApellido("Vaernet");

        EstudianteService eService= new EstudianteService();
        eService.setEstudianteIDao(new EstudianteDAOH2());

        eService.guardarEstudiante(e1);


    }
}
