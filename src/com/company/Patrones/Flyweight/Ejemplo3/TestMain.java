package com.company.Patrones.Flyweight.Ejemplo3;

import java.util.ArrayList;
import java.util.List;

public class TestMain {



    public static void main(String[] args) {

         Arbol a1= new Arbol("Ornamentanl",200,400,"verde");
         Arbol a2= new Arbol("Frutal",500,300,"rojo");
        List<Arbol> listaArboles =new ArrayList<>();

        for (int i=0; i<500000;i++){
            //Con Flyweight

            listaArboles.add(ArbolFactory.getArbol(a1.getTipo(),a1.getAlto(),a1.getAncho(),a1.getColor()));
            listaArboles.add(ArbolFactory.getArbol(a2.getTipo(),a2.getAlto(),a2.getAncho(),a2.getColor()));


            //Sin Flyweight
            /*
            listaArboles.add(new Arbol("Ornamentanl",200,400,"verde"));
            listaArboles.add(new Arbol("Frutal",500,300,"rojo"));
             */
        }
        System.out.println(listaArboles.size());

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));


    }
}
