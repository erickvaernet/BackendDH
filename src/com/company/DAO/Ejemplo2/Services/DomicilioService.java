package com.company.DAO.Ejemplo2.Services;

import com.company.DAO.Ejemplo1.dao.IDao;
import com.company.DAO.Ejemplo2.Models.Domicilio;

import java.util.List;

public class DomicilioService {

    private IDao<Domicilio> domicilioIDao;

    public Domicilio guardarDomicilio(Domicilio domicilio){
        return this.domicilioIDao.guardar(domicilio);
    }

    public void eliminarDomicilio(Long id){
        this.domicilioIDao.eliminar(id);
    }

    public Domicilio buscarDomicilio(Long id){
        return this.domicilioIDao.buscar(id);
    }

    public List<Domicilio> buscarTodos(){
        return  this.domicilioIDao.buscarTodos();
    }

}
