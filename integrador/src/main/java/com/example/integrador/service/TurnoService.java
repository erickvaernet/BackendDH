package com.example.integrador.service;

import com.example.integrador.domain.Turno;
import com.example.integrador.repository.IDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public void eliminarTurno(int id){
        turnoRepository.delete(id);
    }

    public Turno getTurno(int id){
        return  turnoRepository.get(id);
    }

    public Turno updateTurno(Turno turno){
        return turnoRepository.update(turno);
    }
}
