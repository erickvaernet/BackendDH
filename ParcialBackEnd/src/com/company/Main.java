package com.company;

import com.company.DAO.DBH2Singleton;
import com.company.DAO.OdontologoDAOH2;
import com.company.Models.Odontologo;
import com.company.Services.OdontologoService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Odontologo o1 = new Odontologo(256789, "Rick", "Sanchez");
        Odontologo o2 = new Odontologo(472369, "Moira", "Rodriguez");
        Odontologo o3 = new Odontologo(765321, "Olga", "Pochon");

        OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2());

        odontologoService.guardarOdontologo(o1);
        odontologoService.guardarOdontologo(o2);
        odontologoService.guardarOdontologo(o3);

        System.out.println("Odontologo de id=1 -> "+odontologoService.buscarOdontologo(1));

        //odontologoService.eliminarOdontologo(2);

        System.out.println("Lista de Odontologos en la base de datos:");
        List<Odontologo> odontologoList= odontologoService.listarOdontologos();

        for (Odontologo o:odontologoList
             ) {
            System.out.println(" -> " + o);
        }


    }
}
