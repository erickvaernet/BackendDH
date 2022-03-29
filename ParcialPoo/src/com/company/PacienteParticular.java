package com.company;

public class PacienteParticular extends Paciente{
    private Double precioConsulta;
    private Integer dni;

    public PacienteParticular(String fechaNacimiento, String nombre, String apellido, Consulta consulta,
                              boolean primeraConsulta, Double precioConsulta, Integer dni) {
        super(fechaNacimiento, nombre, apellido, consulta, primeraConsulta);
        this.precioConsulta = precioConsulta;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "PacienteParticular{" + super.toString()+
                ", precioConsulta=" + precioConsulta +
                ", dni=" + dni +
                '}';
    }
}
