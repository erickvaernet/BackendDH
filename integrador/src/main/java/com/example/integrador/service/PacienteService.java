package com.example.integrador.service;

import com.example.integrador.domain.Paciente;
import com.example.integrador.repository.IDAO;

import java.util.List;

public class PacienteService {
    private IDAO<Paciente> pacienteDao;

    public PacienteService(IDAO<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public Paciente createPaciente(Paciente paciente){
        return this.pacienteDao.create(paciente);
    };

    public Paciente update(Paciente paciente){
        return this.pacienteDao.update(paciente);
    };

    public void delete(int id){
        this.pacienteDao.delete(id);
    };

    public Paciente get(int id){
        return this.pacienteDao.get(id);
    };

    public List<Paciente> list(){
        return this.pacienteDao.list();
    };

    /*public void deleteFromTo(int firstId,int lastId){
        for (int id = firstId; id <= lastId; id++) {
            this.pacienteDao.delete(id);
        }
    };*/

}
