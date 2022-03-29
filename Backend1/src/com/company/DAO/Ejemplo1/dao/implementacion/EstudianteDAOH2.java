package com.company.DAO.Ejemplo1.dao.implementacion;

import com.company.DAO.Ejemplo1.dao.IDao;
import com.company.DAO.Ejemplo1.model.Estudiante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOH2 implements IDao<Estudiante> {

    private final String DB_JDBC_DRIVER="org.h2.Driver";
    private final String DB_URL="jdbc:h2:~/test";
    private final String DB_USER="sa";
    private final String DB_PASSWORD="";


    @Override
    public Estudiante guardar(Estudiante estudiante) {
        Connection connection=null;
        PreparedStatement ps=null;

        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            ps= connection.prepareStatement("INSERT INTO estudiantes VALUES (?,?,?)");
            ps.setLong(1,estudiante.getId());
            ps.setString(2, estudiante.getNombre());
            ps.setString(3, estudiante.getApellido());

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
        return estudiante;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection=null;
        PreparedStatement ps=null;

        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            ps= connection.prepareStatement("DELETE FROM estudiantes WHERE id=?");
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
    public Estudiante buscar(Long id) {
        Connection connection=null;
        PreparedStatement ps=null;
        Estudiante estudiante=null;

        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            ps= connection.prepareStatement("SELECT * FROM estudiantes WHERE id=?");
            ps.setLong(1,id);

            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                Long idEstudiante= rs.getLong("id");
                String nombreEstudiante= rs.getString("nombre");
                String apellidoEstudiante= rs.getString("apellido");
                estudiante= new Estudiante();
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombreEstudiante);
                estudiante.setApellido(apellidoEstudiante);
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
        return estudiante;
    }

    @Override
    public List<Estudiante> buscarTodos() {
        Connection connection=null;
        PreparedStatement ps=null;
        List<Estudiante> estudiantes=new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            ps= connection.prepareStatement("SELECT * FROM estudiantes");


            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                Long idEstudiante= rs.getLong("id");
                String nombreEstudiante= rs.getString("nombre");
                String apellidoEstudiante= rs.getString("apellido");
                Estudiante estudiante= new Estudiante();
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombreEstudiante);
                estudiante.setApellido(apellidoEstudiante);
                estudiantes.add(estudiante);
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
        return estudiantes;
    }
}
