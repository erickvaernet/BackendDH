package com.company.JDBC.Ejemplos3;

import org.apache.log4j.Logger;

import javax.management.Query;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestMainJDBC3 {
    private static final Logger logger= Logger.getLogger(TestMainJDBC3.class);

    public static void main(String[] args) {

        Connection connection=null;
        Statement stmt;
        String createTable= """
            DROP TABLE IF EXISTS EMPLEADOS;
            CREATE TABLE EMPLEADOS(ID INT PRIMARY KEY, NAME VARCHAR(80), EDAD INT, EMPRESA VARCHAR(80),FECHA DATE);                                
            """;
        String insertEmpleados= """
            INSERT INTO EMPLEADOS VALUES(1, 'Juan',28,'Digital','2022-03-04');
            INSERT INTO EMPLEADOS VALUES(2, 'Carlos',27,'Google','2022-03-10');
            INSERT INTO EMPLEADOS VALUES(3, 'Ivan',25,'Facebook','2022-02-08');            
            """;
        String queryEmpleados="select * from EMPLEADOS";

        try {
            logger.info("Obteniendo el Driver de la Base de Datos");
            Class.forName("org.h2.Driver").newInstance();

            logger.info("Obteniendo conexion a la Base de Datos");
            connection= DriverManager.getConnection("jdbc:h2:/~/test", "sa", "");


            logger.info("Creando Tabla Empleados en la Base de Datos");
            stmt=connection.createStatement();
            stmt.execute(createTable);

            logger.info("Insertando empleados en la Tabla Empleados");
            stmt=connection.createStatement();
            stmt.executeUpdate(insertEmpleados);

            logger.info("Obteniendo los empleados de la Tabla Empleados");
            stmt=connection.createStatement();
            ResultSet results=stmt.executeQuery(queryEmpleados);


            logger.info("Creando Lista de Empleados");
            List<Empleado> empleados= new ArrayList<>();
            while (results.next()){
                empleados.add(new Empleado(results.getLong(1),
                        results.getString(2),
                        results.getInt(3),
                        results.getString(4),
                        results.getDate(5)));
            }

            logger.info("Recorriendo la lista de empleados");
            System.out.println("Empleados: {");
            empleados.forEach((e)->
                    System.out.println("    "+e.getId()+"-"+e.getNombre()
                        +", edad:" + e.getEdad()
                        +", empresa:"+e.getEmpresa()
                        +", fechaInicio:"+e.getFechaInicio()
                    )
            );
            System.out.println("}");


        } catch (Exception e) {
            logger.fatal("Error en la aplicación:",e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Error al cerrar la conexion a la BD",e);
            }
        }










    }
}
