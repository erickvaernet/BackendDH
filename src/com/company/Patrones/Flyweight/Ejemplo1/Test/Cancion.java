package com.company.Patrones.Flyweight.Ejemplo1.Test;

public class Cancion {
    private String nombre;
    private String arista;
    private String genero;

    public Cancion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArista() {
        return arista;
    }

    public void setArista(String arista) {
        this.arista = arista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
