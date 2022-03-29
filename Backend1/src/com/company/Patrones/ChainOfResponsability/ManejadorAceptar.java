package com.company.Patrones.ChainOfResponsability;

public class ManejadorAceptar extends Manejador{

    @Override
    public void comprobar(Articulo arti)
    {
        System.out.println("Se puede proceder a vender el artículo " +arti.getNombre());
    }
}
