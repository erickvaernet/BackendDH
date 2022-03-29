package com.company.Serializacion;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Perro p1 = new Perro("Can","Caniche",10);
        Perro p2 = new Perro("Barry","Boxer",3);
        Perro p3 = new Perro("Roco","Pastor Aleman",5);

        ArrayList<Perro> lunes= new ArrayList<>();
        ArrayList<Perro> martes= new ArrayList<>();
        ArrayList<Perro> miercoles= new ArrayList<>();
        ArrayList<Perro> jueves= new ArrayList<>();
        ArrayList<Perro> viernes= new ArrayList<>();

        lunes.add(p1);
        lunes.add(p2);
        lunes.add(p3);
        martes.add(p2);
        martes.add(p3);
        miercoles.add(p1);
        miercoles.add(p2);
        jueves.add(p3);
        viernes.add(p1);
        viernes.add(p2);

        try {
            FileOutputStream flOut= new FileOutputStream("perros.dat");
            ObjectOutputStream objOut= new ObjectOutputStream(flOut);

            objOut.writeObject(lunes);
            objOut.writeObject(martes);
            objOut.writeObject(miercoles);
            objOut.writeObject(jueves);
            objOut.writeObject(viernes);

            objOut.close();
            flOut.close();

            FileInputStream flIn= new FileInputStream("perros.dat");
            ObjectInputStream objIn= new ObjectInputStream(flIn);

            ArrayList<Perro> listaPerros;
            for (int i=0;i<5;i++){
                listaPerros= (ArrayList<Perro>) objIn.readObject();
                System.out.println("Dia "+(i+1));
                System.out.println("-----------------");
                for (Perro p:listaPerros
                     ) {
                    System.out.println(p.toString());
                }
                System.out.println("-----------------");
                System.out.println(" ");
            }
            objIn.close();
            flIn.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
