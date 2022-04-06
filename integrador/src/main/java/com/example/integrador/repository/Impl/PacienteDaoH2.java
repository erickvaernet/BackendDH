package com.example.integrador.repository.Impl;

import com.example.integrador.domain.Domicilio;
import com.example.integrador.domain.Paciente;
import com.example.integrador.repository.IDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDAO<Paciente> {
    private static final Logger logger= LogManager.getLogger(PacienteDaoH2.class);
    private static final String DB_JDBC_DRIVER="org.h2.Driver";
    private static final String DB_URL="jdbc:h2:tcp://localhost/~/test;";
    private static final String DB_USER="sa";
    private static final String DB_PASSWORD="";
    private DomicilioDaoH2 domicilioDaoH2=new DomicilioDaoH2();

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DB_JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
    }

    @Override
    public Paciente create(Paciente paciente) {
        Connection connection=null;
        PreparedStatement ps=null;
        int id;
        try{
            //Establecer conexion
            connection=getConnection();
            //Obtener el domicilio
            Domicilio domicilio = domicilioDaoH2.create(paciente.getDomicilio());
            paciente.getDomicilio().setId(domicilio.getId());

            ps=connection.prepareStatement(
                    "INSERT INTO PACIENTES (nombre,apellido,email,dni,fecha_ingreso,domicilio_id) VALUES (?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1,paciente.getNombre());
            ps.setString(2,paciente.getApellido());
            ps.setString(3,paciente.getEmail());
            ps.setLong(4,paciente.getDni());
            ps.setDate(5, Date.valueOf(paciente.getFechaIngreso()));
            ps.setInt(6,paciente.getDomicilio().getId());
            ps.executeUpdate();

            ResultSet keys= ps.getGeneratedKeys();
            if(keys.next()){
                paciente.setId(keys.getInt(1));
            }
            ps.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Paciente update( Paciente paciente) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Domicilio domicilio = domicilioDaoH2.update(paciente.getDomicilio());
            ps = connection.prepareStatement("UPDATE pacientes SET nombre=?, apellido=?,email=?, dni=?, fecha_ingreso=?, domicilio_id=?  WHERE id = ?");
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getEmail());
            ps.setLong(4, paciente.getDni());
            ps.setDate(5,Date.valueOf(paciente.getFechaIngreso()));
            ps.setInt(6, paciente.getDomicilio().getId());
            ps.setInt(7, paciente.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return paciente;
    }


    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ps = connection.prepareStatement("DELETE FROM pacientes where id = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Paciente get(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        Paciente paciente = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ps = connection.prepareStatement("SELECT id,nombre,apellido,email,dni,fecha_ingreso,domicilio_id  FROM pacientes where id = ?");
            ps.setInt(1,id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int idPaciente = result.getInt("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String email = result.getString("email");
                long dni = result.getLong("dni");
                LocalDate fechaIngreso = result.getDate("fecha_ingreso").toLocalDate();
                int idDomicilio = result.getInt("domicilio_id");
                Domicilio domicilio = domicilioDaoH2.get(idDomicilio);
                paciente = new Paciente(idPaciente,nombre,apellido,email,dni,fechaIngreso,domicilio);
            }
            ps.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return paciente;
    }

    @Override
    public List<Paciente> list() {
        Connection connection = null;
        PreparedStatement ps = null;
        List<Paciente> pacientes = new ArrayList<>();
        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ps = connection.prepareStatement("SELECT *  FROM pacientes");
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                int idPaciente = result.getInt("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String email = result.getString("email");
                long dni = result.getLong("dni");
                LocalDate fechaIngreso = result.getDate("fecha_ingreso").toLocalDate();
                int idDomicilio = result.getInt("domicilio_id");

                Domicilio domicilio = domicilioDaoH2.get(idDomicilio);
                Paciente paciente = new Paciente(idPaciente,nombre,apellido,email,dni,fechaIngreso,domicilio);
                pacientes.add(paciente);
            }

            ps.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return pacientes;
    }
}
