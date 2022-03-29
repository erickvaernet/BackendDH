package com.company.Services;

import com.company.DAO.IDAO;
import com.company.Models.Odontologo;
import java.util.List;

public class OdontologoService {
    private final IDAO<Odontologo> DAO;

    public OdontologoService(IDAO<Odontologo> DAO) {
        this.DAO = DAO;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return  DAO.guardar(odontologo);
    }

    public void eliminarOdontologo(int id) {
        DAO.eliminar(id);
    }

    public Odontologo buscarOdontologo(int id) {
        return DAO.buscar(id);
    }

    public List<Odontologo> listarOdontologos() {
        return DAO.buscarTodos();
    }
}
