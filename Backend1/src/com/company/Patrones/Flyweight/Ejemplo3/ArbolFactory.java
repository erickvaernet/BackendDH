package com.company.Patrones.Flyweight.Ejemplo3;

import java.util.HashMap;

public class ArbolFactory {

    private static final HashMap<String,Arbol> arboles = new HashMap<>();

    public static Arbol getArbol(String tipo, int alto, int ancho, String color){

        String clave=tipo+alto+ancho+color;
        Arbol arbol= arboles.get(clave);

        if(arbol==null){
            arbol= new Arbol(tipo,alto,ancho,color);
            arboles.put(clave, arbol);
        }
        return arbol;
    }
}
