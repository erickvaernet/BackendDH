package com.company.Patrones.ChainOfResponsability;

public abstract class Manejador {

    private Manejador siguienteManejador;

    public Manejador getSiguienteManejador() {
        return siguienteManejador;
    }

    public void setSiguienteManejador(Manejador siguenteManejador) {
        this.siguienteManejador = siguenteManejador;
    }

    public abstract void comprobar(Articulo art);
}
