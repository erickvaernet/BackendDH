package clase6;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Perro {
    boolean enAdopcion;
    String raza;
    int anioNacimiento;
    double pesoEnKg;
    boolean chip;
    boolean lastimado;
    String nombrePila;


    public Perro(String raza, int anioNacimiento, double pesoEnKg, boolean chip, boolean lastimado, String nombrePila) {
        this.raza = raza;
        this.anioNacimiento = anioNacimiento;
        this.pesoEnKg = pesoEnKg;
        this.chip = chip;
        this.lastimado = lastimado;
        this.nombrePila = nombrePila;
        this.enAdopcion= (!lastimado && pesoEnKg > 5);
    }

    public Perro(int anioNacimiento, double pesoEnKg, boolean chip, boolean lastimado, String nombrePila) {
        this.anioNacimiento = anioNacimiento;
        this.pesoEnKg = pesoEnKg;
        this.chip = chip;
        this.lastimado = lastimado;
        this.nombrePila = nombrePila;
        this.enAdopcion= (!lastimado && pesoEnKg > 5);
    }

    /* GETERS y SETTERS*/
    public boolean isEnAdopcion() {
        return enAdopcion;
    }
    public void setEnAdopcion(boolean enAdopcion) {
        this.enAdopcion = enAdopcion;
    }

    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }
    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public double getPesoEnKg() {
        return pesoEnKg;
    }
    public void setPesoEnKg(double pesoEnKg) {
        this.pesoEnKg = pesoEnKg;
    }

    public boolean isChip() {
        return chip;
    }
    public void setChip(boolean chip) {
        this.chip = chip;
    }

    public boolean isLastimado() {
        return lastimado;
    }
    public void setLastimado(boolean lastimado) {
        this.lastimado = lastimado;
    }

    public String getNombrePila() {
        return nombrePila;
    }
    public void setNombrePila(String nombrePila) {
        this.nombrePila = nombrePila;
    }


    /* Métodos Própios*/
    public boolean puedePerderse(){
        return !this.chip;
    }
    public int obtenerEdadEnAnios(){
        Date fecha = new Date();
        SimpleDateFormat darFormatoanio = new SimpleDateFormat("yyyy");
        int anioActual=Integer.parseInt(darFormatoanio.format(fecha));
        return anioActual - this.anioNacimiento;
    }


    /*Sobrescritos*/

    @Override
    public String toString() {
        return "Perro{" +
                "enAdopcion=" + enAdopcion +
                ", raza='" + raza + '\'' +
                ", anioNacimiento=" + anioNacimiento +
                ", pesoEnKg=" + pesoEnKg +
                ", chip=" + chip +
                ", lastimado=" + lastimado +
                ", nombrePila='" + nombrePila + '\'' +
                '}';
    }
}
