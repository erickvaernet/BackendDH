package com.company.Patrones.Flyweight;

import java.util.HashMap;

public class Lista {

    private static final HashMap<String,Cancion> cancionesMap = new HashMap();

    public static Cancion getCancion(String nombreCancion){
        Cancion cancion = cancionesMap.get(nombreCancion);
        if(cancion==null){
            cancion= new Cancion(nombreCancion);
            cancionesMap.put(nombreCancion,cancion);
            System.out.println("Se creo la cancion = " + cancion);
        }
        return cancion;
    }
}
