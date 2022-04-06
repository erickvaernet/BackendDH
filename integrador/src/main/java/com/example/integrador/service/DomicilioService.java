package com.example.integrador.service;

import com.example.integrador.domain.Domicilio;
import com.example.integrador.repository.IDAO;

import java.util.List;

public class DomicilioService {
    private IDAO<Domicilio> domicilioDao;

    public DomicilioService(IDAO<Domicilio> domicilioDao) {
        this.domicilioDao = domicilioDao;
    }

    public Domicilio createDomicilio(Domicilio domicilio){
        return this.domicilioDao.create(domicilio);
    };

    public Domicilio update(Domicilio domicilio){
        return this.domicilioDao.update(domicilio);
    };

    public void delete(int id){
        this.domicilioDao.delete(id);
    };

    public Domicilio get(int id){
        return this.domicilioDao.get(id);
    };

    public List<Domicilio> list(){
        return this.domicilioDao.list();
    };




}
