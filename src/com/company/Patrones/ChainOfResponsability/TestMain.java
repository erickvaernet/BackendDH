package com.company.Patrones.ChainOfResponsability;

public class TestMain {

    public static void main(String[] args) {

        CompruebaCalidad comprobador = new CompruebaCalidad();
        comprobador.comprobar(new Articulo("carne", 1100,1300, "sano"));
        comprobador.comprobar(new Articulo("pastas", 1100,1300, "epepepe"));

    }
}
