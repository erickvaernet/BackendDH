package com.company;

public class Consulta {
    private String fechaConsulta;
    private String especialidad;
    private Integer horaConsulta;
    private Integer minutoConsulta;

    public Consulta(String fechaConsulta, String especialidad, Integer horaConsulta, Integer minutoConsulta) {
        this.fechaConsulta = fechaConsulta;
        this.especialidad = especialidad;
        this.horaConsulta = horaConsulta;
        this.minutoConsulta = minutoConsulta;
    }
}
