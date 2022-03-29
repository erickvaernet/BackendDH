package com.company;

public class Paciente {
    private String fechaNacimiento;
    private String nombre;
    private String apellido;
    private Consulta consulta;
    private boolean primeraConsulta;

    public boolean debeRealizarseEvaluacionInicial(){
        return primeraConsulta? true:false;
    }

    public Paciente(String fechaNacimiento, String nombre, String apellido, Consulta consulta, boolean primeraConsulta) {
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.consulta = consulta;
        this.primeraConsulta = primeraConsulta;
    }

    @Override
    public String toString() {
        return
                "fechaNacimiento='" + fechaNacimiento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", consulta=" + consulta +
                ", primeraConsulta=" + primeraConsulta;
    }
}
