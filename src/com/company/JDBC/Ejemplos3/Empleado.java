package com.company.JDBC.Ejemplos3;

import java.sql.Date;
import java.time.LocalDate;

public class Empleado {

    private long id;
    private String nombre;
    private int edad;
    private String empresa;
    private LocalDate fechaInicio;

    public Empleado(long id, String nombre, int edad, String empresa, Date fechaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.empresa = empresa;
        this.fechaInicio = fechaInicio.toLocalDate();
    }
    public Empleado(long id, String nombre, int edad, String empresa, LocalDate fechaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.empresa = empresa;
        this.fechaInicio = fechaInicio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
