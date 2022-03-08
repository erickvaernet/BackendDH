package com.company.Patrones.Flyweight.Ejemplo2;

public class Computadora {

    private int id;
    private int disco;
    private int ram;
    public static int contador;

    public Computadora(int ram, int disco) {
        this.ram = ram;
        this.disco = disco;
        contador++;
        System.out.println("contador: " + contador);
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public static int getContador() {
        return contador;
    }

    public int getDisco() {
        return disco;
    }

    public void setDisco(int disco) {
        this.disco = disco;
    }

    @Override
    public String toString() {
        return "Computer [ram=" + ram + ", disco=" + disco + "]";
    }
}
