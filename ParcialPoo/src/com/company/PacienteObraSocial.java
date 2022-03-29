package com.company;

public class PacienteObraSocial extends Paciente implements Comparable<PacienteObraSocial>{
    private String nombreObraSocial;
    private Integer numeroDeAsociado;

    public PacienteObraSocial(String fechaNacimiento, String nombre, String apellido, Consulta consulta,
                              boolean primeraConsulta, String nombreObraSocial, Integer numeroDeAsociado) {
        super(fechaNacimiento, nombre, apellido, consulta, primeraConsulta);
        this.nombreObraSocial=nombreObraSocial;
        this.numeroDeAsociado= numeroDeAsociado;
    }

    @Override
    public int compareTo(PacienteObraSocial o) {
        if (this.numeroDeAsociado < o.numeroDeAsociado) return -1;
        else if (this.numeroDeAsociado > o.numeroDeAsociado) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "PacienteObraSocial{" + super.toString()+
                ", nombreObraSocial='" + nombreObraSocial + '\'' +
                ", numeroDeAsociado=" + numeroDeAsociado +
                '}';
    }
}
