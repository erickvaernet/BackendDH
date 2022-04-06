package com.example.integrador.repository.Impl;

import com.example.integrador.domain.Domicilio;
import com.example.integrador.repository.IDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 implements IDAO<Domicilio> {
    private static final Logger logger= LogManager.getLogger(DomicilioDaoH2.class);
    private static final String DB_JDBC_DRIVER="org.h2.Driver";
    private static final String DB_URL="jdbc:h2:tcp://localhost/~/test;";
    private static final String DB_USER="sa";
    private static final String DB_PASSWORD="";


    @Override
    public Domicilio create(Domicilio domicilio) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ps = connection.prepareStatement(
                    "INSERT INTO domicilios(calle,numero,localidad,provincia) VALUES(?,?,?,?)"
                    , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, domicilio.getCalle());
            ps.setInt(2, domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()) domicilio.setId(keys.getInt(1));
            ps.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return domicilio;
    }

    @Override
    public Domicilio update( Domicilio domicilio) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ps = connection.prepareStatement("UPDATE domicilios SET calle = ?, numero = ? ,localidad = ?, provincia = ?  WHERE id = ?");
            ps.setString(1, domicilio.getCalle());
            ps.setInt(2, domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.setInt(5, domicilio.getId());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return domicilio;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ps = connection.prepareStatement("DELETE FROM domicilios where id = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Domicilio get(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        Domicilio domicilio = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ps = connection.prepareStatement("SELECT id,calle,numero,localidad,provincia FROM domicilios where id = ?");
            ps.setInt(1,id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int idDomicilio = result.getInt("id");
                String calle = result.getString("calle");
                int numero = result.getInt("numero");
                String localidad = result.getString("localidad");
                String provincia = result.getString("provincia");
                domicilio = new Domicilio(idDomicilio,calle,numero,localidad,provincia);
            }
            ps.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return domicilio;
    }

    @Override
    public List<Domicilio> list() {
        Connection connection = null;
        PreparedStatement ps = null;
        List<Domicilio> domicilios = new ArrayList<>();
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ps = connection.prepareStatement("SELECT *  FROM domicilios");
            ResultSet result = ps.executeQuery();
            while (result.next()) {

                int idDomicilio = result.getInt("id");
                String calle = result.getString("calle");
                int numero = result.getInt("numero");
                String localidad = result.getString("localidad");
                String provincia = result.getString("provincia");

                Domicilio domicilio = new Domicilio(idDomicilio,calle,numero,localidad,provincia);

                domicilios.add(domicilio);

            }
            ps.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return domicilios;
    }
}
