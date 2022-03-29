package com.company.Patrones.Flyweight.Ejemplo2;

import java.util.HashMap;

public class ComputadoraFactory {

    private static final HashMap<String,Computadora> computadoras= new HashMap<>();

    public static Computadora getComputadora(int ram, int disco){
        String clave="ram:"+ram+"disco:"+disco;
        Computadora computadora=computadoras.get(clave);

        if(computadora==null){
            computadora= new Computadora(ram,disco);
            clave="ram:"+computadora.getRam()+"disco:"+computadora.getDisco();
             computadoras.put(clave,computadora);
        }

        return computadora;
    }

}
