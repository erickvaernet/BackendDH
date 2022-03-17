package com.company.DAO.Ejemplo2.DAO.impl;

import com.company.DAO.Ejemplo2.DAO.IDAO;
import com.company.DAO.Ejemplo2.Models.Domicilio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDAOH2 implements IDAO<Domicilio> {
    private final String DB_JDBC_DRIVER="org.h2.Driver";
    private final String DB_URL="jdbc:h2:~/test";
    private final String DB_USER="sa";
    private final String DB_PASSWORD="";

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            ps= connection.prepareStatement("INSERT INTO domicilios VALUES (?,?,?,?,?)");
            ps.setLong(1,domicilio.getId());
            ps.setString(2, domicilio.getCalle());
            ps.setInt(3, domicilio.getNumero());
            ps.setString(4,domicilio.getLocalidad());
            ps.setString(5,domicilio.getProvincia());

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return domicilio;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            ps= connection.prepareStatement("DELETE FROM domicilios WHERE id=?");
            ps.setLong(1,id);

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public Domicilio buscar(Long id) {
        Connection connection=null;
        PreparedStatement ps=null;
        Domicilio domicilio=null;
        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            ps= connection.prepareStatement("SELECT * FROM domicilios WHERE id=?");
            ps.setLong(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Long domicilioId=rs.getLong("id");
                String calleDomicilio=rs.getString("calle");
                int numeroDomicilio=rs.getInt("numero");
                String localidadDomicilio=rs.getString("localidad");
                String provinciaDomicilio=rs.getString("provincia");
                domicilio=new Domicilio(domicilioId,calleDomicilio,numeroDomicilio,localidadDomicilio,provinciaDomicilio);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return domicilio;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        Connection connection=null;
        PreparedStatement ps=null;
        List<Domicilio> domicilios= new ArrayList<>();
        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            ps= connection.prepareStatement("SELECT * FROM domicilios");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Long domicilioId=rs.getLong("id");
                String calleDomicilio=rs.getString("calle");
                int numeroDomicilio=rs.getInt("numero");
                String localidadDomicilio=rs.getString("localidad");
                String provinciaDomicilio=rs.getString("provincia");
                domicilios.add(new Domicilio(domicilioId,calleDomicilio,numeroDomicilio,localidadDomicilio,provinciaDomicilio));
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return domicilios;
    }
}
