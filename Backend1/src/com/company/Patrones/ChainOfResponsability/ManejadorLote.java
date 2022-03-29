package com.company.Patrones.ChainOfResponsability;

public class ManejadorLote extends Manejador{

    @Override
    public void comprobar(Articulo art) {
        if (art.getLote()>2000){
            System.out.println("El Lote del articulo " +art.getNombre() +", se encuentra por encima del N° de lote permitido (2000)");
        }
        else if (art.getLote()<1000){
            System.out.println("El Lote del articulo " +art.getNombre() +", se encuentra por debajo del N° de lote permitido (1000)");
        }
        else {
            this.getSiguienteManejador().comprobar(art);
        }
    }
}
