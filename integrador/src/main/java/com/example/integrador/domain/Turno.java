package com.example.integrador.domain;

import java.time.LocalDate;

public class Turno {
    private int id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate date;

    public Turno() {
    }

    public Turno(int id, Paciente paciente, Odontologo odontologo, LocalDate date) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.date = date;
    }

    public Turno(Paciente paciente, Odontologo odontologo, LocalDate date) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
