package com.company.DAO.Ejemplo2.DAO.impl;

import com.company.DAO.Ejemplo2.DAO.IDAO;
import com.company.DAO.Ejemplo2.Models.Domicilio;
import com.company.DAO.Ejemplo2.Models.Paciente;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class PacienteDAOH2 implements IDAO<Paciente> {
    private final String DB_JDBC_DRIVER="org.h2.Driver";
    private final String DB_URL="jdbc:h2:~/test";
    private final String DB_USER="sa";
    private final String DB_PASSWORD="";

    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            ps= connection.prepareStatement("INSERT INTO pacientes VALUES (?,?,?,?)");
            ps.setLong(1,paciente.getId());
            ps.setLong(2, paciente.getDni());
            ps.setString(3, paciente.getNombre());
            ps.setString(4,paciente.getApellido());
            ps.setDate(5, Date.valueOf(paciente.getFechaIngreso()));
            ps.setLong(6,paciente.getDomicilio().getId());

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
        return paciente;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            ps= connection.prepareStatement("DELETE FROM pacientes WHERE id=?");
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
    public Paciente buscar(Long id) {
        Connection connection=null;
        PreparedStatement ps=null;
        Paciente paciente=null;
        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            ps= connection.prepareStatement("SELECT * FROM pacientes WHERE id=?");
            ps.setLong(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Long pacienteId=rs.getLong("id");
                Long dniPaciente=rs.getLong("dni");
                String nombrePaciente=rs.getString("nombre");
                String apellidoPaciente=rs.getString("apellido");
                LocalDate fechaIngresoPaciente=rs.getDate("fecha_ingreso").toLocalDate();
                Long idDomicilio= rs.getLong("id_domicilio");
                Domicilio domicilioPaciente=new DomicilioDAOH2().buscar(idDomicilio);
                paciente=new Paciente(
                        pacienteId,
                        dniPaciente,
                        nombrePaciente,
                        apellidoPaciente,
                        fechaIngresoPaciente,
                        domicilioPaciente);
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
        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() {
        Connection connection=null;
        PreparedStatement ps=null;
        List<Paciente> pacientes=null;
        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            ps= connection.prepareStatement("SELECT * FROM pacientes ");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Long pacienteId=rs.getLong("id");
                Long dniPaciente=rs.getLong("dni");
                String nombrePaciente=rs.getString("nombre");
                String apellidoPaciente=rs.getString("apellido");
                LocalDate fechaIngresoPaciente=rs.getDate("fecha_ingreso").toLocalDate();
                Long idDomicilio= rs.getLong("id_domicilio");
                Domicilio domicilioPaciente=new DomicilioDAOH2().buscar(idDomicilio);
                pacientes.add(
                        new Paciente(
                                pacienteId,
                                dniPaciente,
                                nombrePaciente,
                                apellidoPaciente,
                                fechaIngresoPaciente,
                                domicilioPaciente
                        )
                );
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
        return pacientes;
    }
}
