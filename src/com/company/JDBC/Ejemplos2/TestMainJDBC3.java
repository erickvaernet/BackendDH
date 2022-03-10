package com.company.JDBC.Ejemplos2;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TestMainJDBC3 {
    private static final Logger logger= Logger.getLogger(TestMainJDBC3.class);
    public static void main(String[] args) {

        try {
            Class.forName("org.h2.Driver").newInstance();
        } catch (Exception e) {
            logger.fatal("Error en obtencion de instancia del Driver h2",e);
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:"+"./Database/my", "root", "myPassword");
        } catch (SQLException e) {
            logger.fatal("Error al obtener la conexion la Base de Datos",e);
        }

        Statement stmt = null;
        String query= "select * from TEST";
        List<Test> tests= new ArrayList<>();
        try {
            stmt= connection.createStatement();
            ResultSet result= stmt.executeQuery(query);

            while(result.next()){
                tests.add(new Test(result.getInt(1),result.getString(2)));
            }

            tests.forEach((e)->{
                System.out.println("Test: "+e.getId()+" - "+e.getName());
            });


        } catch (SQLException e) {
            logger.error("Error en la creación y/o ejecucion de la consulta",e);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            logger.error("Error al cerrar la conexion a la BD",e);
        }
        ;


    }
}
