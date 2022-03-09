package com.company.Log4J;



public abstract class Animal {
    private String nombre;
    private int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        if(edad<0)
            throw new RuntimeException("la edad del "+this.getClass().getSimpleName()+" "+getNombre()+" no puede ser menor a 0");
        else
            this.edad = edad;
    }

    public void correr(){
        StaticLogger.logger.info("El "+this.getClass().getSimpleName()+" esta corriendo");
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
