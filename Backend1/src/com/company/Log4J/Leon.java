package com.company.Log4J;

public class Leon extends Animal {

    private  boolean esAlfa;

    public Leon(String nombre, int edad, boolean esAlfa) {
        super(nombre, edad);
        this.esAlfa=esAlfa;
    }

    public boolean isEsAlfa() {
        return esAlfa;
    }

    public void setEsAlfa(boolean esAlfa) {
        this.esAlfa = esAlfa;
    }

    public void esMayorA10(){
        if(getEdad()>10 && esAlfa)
            StaticLogger.logger.info("El leon "+getNombre()+" es alfa y tiene una edad de "+getEdad());
        else if(esAlfa)
            StaticLogger.logger.warn("La edad del leon alfa "+getNombre()+" es menor a 10");
        else if(getEdad()>10){
            StaticLogger.logger.warn("La edad del leon "+getNombre()+" es mayor a 10 pero no es alfa");
        }
        else
            StaticLogger.logger.error("EL leon "+getNombre()+" tiene edad menor a 10 y tampoco es alfa");
    }


}
