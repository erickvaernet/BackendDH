package com.example.integrador.repository.Impl;

import com.example.integrador.domain.Odontologo;
import com.example.integrador.repository.IDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OdontologoDaoH2 implements IDAO<Odontologo> {
    private static final Logger logger= LogManager.getLogger(PacienteDaoH2.class);
    private static final String DB_JDBC_DRIVER="org.h2.Driver";
    private static final String DB_URL="jdbc:h2:tcp://localhost/~/test;";
    private static final String DB_USER="sa";
    private static final String DB_PASSWORD="";


    @Override
    public Odontologo create(Odontologo odontologo) {
        Connection cn;
        PreparedStatement ps;
        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            cn= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            ps= cn.prepareStatement("INSERT INTO ODONTOLOGOS (nombre,apellido,matricula) VALUES(?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,odontologo.getNombre());
            ps.setString(2,odontologo.getApellido());
            ps.setInt(3,odontologo.getMatricula());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()) odontologo.setId(rs.getInt(1));
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public Odontologo update(Odontologo odontologo) {
        Connection cn;
        PreparedStatement ps;
        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            cn= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            ps= cn.prepareStatement("UPDATE odontologos SET nombre=?, apellido=?, matricula=? WHERE id=?");
            ps.setString(1,odontologo.getNombre());
            ps.setString(2,odontologo.getApellido());
            ps.setInt(3,odontologo.getMatricula());
            ps.setInt(4,odontologo.getId());
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public void delete(int id) {
        Connection cn;
        PreparedStatement ps;
        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            cn= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            ps= cn.prepareStatement("DELETE FROM ODONTOLOGOS WHERE id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Odontologo get(int id) {
        Connection cn;
        PreparedStatement ps;
        Odontologo odontologo = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            cn= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            ps= cn.prepareStatement("SELECT nombre,apellido,matricula FROM ODONTOLOGOS WHERE id=?");
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                int matricula=rs.getInt("matricula");
                odontologo= new Odontologo(id,nombre,apellido,matricula);
            }
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> list() {
        Connection cn;
        PreparedStatement ps;
        List<Odontologo> odontologos= new ArrayList<>();
        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            cn= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            ps= cn.prepareStatement("SELECT id,nombre,apellido,matricula FROM ODONTOLOGOS");
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                int matricula=rs.getInt("matricula");
                odontologos.add(new Odontologo(id,nombre,apellido,matricula));
            }
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return odontologos;
    }
}
