package com.company.Patrones.ChainOfResponsability;

public class CompruebaCalidad {

    private Manejador manejadorInicial;

    public CompruebaCalidad() {
        this.manejadorInicial = new ManejadorLote();
        Manejador peso = new ManejadorPeso();
        Manejador envase = new ManejadorEnvase();
        Manejador acepta = new ManejadorAceptar();

        manejadorInicial.setSiguienteManejador( peso );
        peso.setSiguienteManejador( envase );
        envase.setSiguienteManejador( acepta );
    }

    public void comprobar(Articulo art){
        this.manejadorInicial.comprobar(art);
    }
}
