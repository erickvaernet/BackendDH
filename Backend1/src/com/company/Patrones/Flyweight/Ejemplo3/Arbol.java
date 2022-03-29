package com.company.Patrones.Flyweight.Ejemplo3;

public class Arbol {

    private String tipo;
    private int alto;
    private int ancho;
    private String color;

    public Arbol( String tipo,int alto, int ancho, String color) {
        this.tipo = tipo;
        this.alto = alto;
        this.ancho = ancho;
        this.color = color;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Arbol{" +
                "tipo='" + tipo + '\'' +
                ", alto=" + alto +
                ", ancho=" + ancho +
                ", color='" + color + '\'' +
                '}';
    }
}
