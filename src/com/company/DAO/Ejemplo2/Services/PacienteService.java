package com.company.DAO.Ejemplo2.Services;

import com.company.DAO.Ejemplo1.dao.IDao;
import com.company.DAO.Ejemplo2.Models.Paciente;

import java.util.List;

public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public Paciente guardarPaciente(Paciente paciente){
        return this.pacienteIDao.guardar(paciente);
    }

    public void eliminarPaciente(Long id){
        this.pacienteIDao.eliminar(id);
    }

    public Paciente buscarPaciente(Long id){
        return this.pacienteIDao.buscar(id);
    }

    public List<Paciente> buscarTodos(){
        return  this.pacienteIDao.buscarTodos();
    }



}
