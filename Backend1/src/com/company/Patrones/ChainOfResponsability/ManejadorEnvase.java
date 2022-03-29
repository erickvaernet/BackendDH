package com.company.Patrones.ChainOfResponsability;

public class ManejadorEnvase extends Manejador{

    @Override
    public void comprobar(Articulo art) {
        if (!art.getEnvasado().equalsIgnoreCase("sano") &&
                !art.getEnvasado().equalsIgnoreCase("casi sano"))
        {
            System.out.println("La calidad del envase del articulo "+art.getNombre()+" no es el esperado");
        }
        else
        {
            this.getSiguienteManejador().comprobar( art );
        }
    }
}
