package com.example.integrador.repository.Impl;

import com.example.integrador.domain.Odontologo;
import com.example.integrador.repository.IDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class OdontologoDaoH2 implements IDAO<Odontologo> {
    private static final Logger logger= LogManager.getLogger(PacienteDaoH2.class);
    private static final String DB_JDBC_DRIVER="org.h2.Driver";
    private static final String DB_URL="jdbc:h2:tcp://localhost/~/test;";
    private static final String DB_USER="sa";
    private static final String DB_PASSWORD="";


    @Override
    public Odontologo create(Odontologo newObject) {
        Connection cn;
        PreparedStatement ps;
        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Odontologo update(Odontologo objectToBeUpdated) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Odontologo get(int id) {
        return null;
    }

    @Override
    public List<Odontologo> list() {
        return null;
    }
}
