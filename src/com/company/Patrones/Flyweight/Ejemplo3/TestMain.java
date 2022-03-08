package com.company.Patrones.Flyweight.Ejemplo3;

public class TestMain {



    public static void main(String[] args) {

         Arbol a1= new Arbol("Ornamentanl",200,400,"verde");
         Arbol a2= new Arbol("Frutal",500,300,"rojo");
         Arbol a3;
         Arbol a4;

        for (int i=0; i<500000;i++){
            a3=ArbolFactory.getArbol(a1.getTipo(),a1.getAlto(),a1.getAncho(),a1.getColor());
            a4=ArbolFactory.getArbol(a2.getTipo(),a2.getAlto(),a2.getAncho(),a2.getColor());
            System.out.println(a3.toString());
            System.out.println(a4.toString());
        }

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));



    }
}
