package com.example.integrador.repository.Impl;

import com.example.integrador.domain.Turno;
import com.example.integrador.repository.IDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TurnosListaDaoH2 implements IDAO<Turno>{

    private List<Turno> turnos;

    public TurnosListaDaoH2() {
        turnos = new ArrayList<>();
    }

    @Override
    public Turno create(Turno turno) {
        turnos.add(turno);
        return turno;
    }

    @Override
    public Turno get(int id) {
        for(Turno turno : turnos){
            if(turno.getId()==id){
                return turno;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        for(Turno turno : turnos){
            if(turno.getId()==id){
                turnos.remove(turno);
                return;
            }
        }

    }

    @Override
    public List<Turno> list() {
        return turnos;
    }

    @Override
    public Turno update(Turno turno) {
        delete(turno.getId());
        turnos.add(turno);
        return turno;
    }
}
