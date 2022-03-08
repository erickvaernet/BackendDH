package com.company.Patrones.Flyweight.Ejemplo1.Test;

import com.company.Patrones.Flyweight.Ejemplo1.Test.Cancion;

import java.util.HashMap;

public class Lista {

    private static final HashMap<String, Cancion> cancionesMap = new HashMap();

    public static Cancion getCancion(String nombre, String artista, String genero){
        String clave = nombre+artista+genero;
        Cancion cancion = cancionesMap.get(clave);
        if(cancion==null){
            cancion= new Cancion(nombre,artista,genero);
            clave= nombre+artista+genero;
            cancionesMap.put(clave,cancion);
            System.out.println("Se creo la cancion = Nombre:" + cancion.getNombre()+", Artista:"+ cancion.getArista()+", Genero:"+cancion.getGenero());
        }
        return cancion;
    }
}
