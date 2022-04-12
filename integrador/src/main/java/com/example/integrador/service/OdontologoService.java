package com.example.integrador.service;

import com.example.integrador.domain.Odontologo;
import com.example.integrador.repository.IDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    private IDAO<Odontologo> odontologoDao;

    public OdontologoService(IDAO<Odontologo> odontologoDao) {
        this.odontologoDao = odontologoDao;
    }

    public Odontologo createOdontologo(Odontologo odontologo){
        return this.odontologoDao.create(odontologo);
    };

    public Odontologo update(Odontologo odontologo){
        return this.odontologoDao.update(odontologo);
    };

    public void delete(int id){
        this.odontologoDao.delete(id);
    };

    public Odontologo get(int id){
        return this.odontologoDao.get(id);
    };

    public List<Odontologo> list(){
        return this.odontologoDao.list();
    };

}
