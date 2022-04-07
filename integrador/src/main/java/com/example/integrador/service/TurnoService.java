package com.example.integrador.service;

import com.example.integrador.domain.Turno;
import com.example.integrador.repository.IDAO;

import java.util.List;

public class TurnoService {

    private IDAO<Turno> turnoRepository;

    public TurnoService(IDAO<Turno> turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno registrarTurno(Turno turno){
        return  turnoRepository.create(turno);
    }
    public List<Turno> list(){
        return turnoRepository.list();
    }
}
