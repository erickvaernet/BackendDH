package com.company.Patrones.ChainOfResponsability;

public class ManejadorPeso  extends  Manejador{

    @Override
    public void comprobar(Articulo art) {
        if (art.getPeso() < 1200) {
            int difMenorPeso = 1200 - art.getPeso();
            System.out.println("El articulo"+art.getNombre()+" fue rechazado por un peso inferior de " + difMenorPeso);
        } else if (art.getPeso() > 1300) {
            int difMayorPeso = art.getPeso() - 1300;
            System.out.println("El articulo"+art.getNombre()+" fue rechazado por un peso mayor de " + difMayorPeso);
        } else {
            this.getSiguienteManejador().comprobar(art);
        }

    }
}
