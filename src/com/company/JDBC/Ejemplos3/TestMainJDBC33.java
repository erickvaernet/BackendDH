package com.company.JDBC.Ejemplos3;

import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestMainJDBC33 {

    private static final Logger logger = Logger.getLogger(TestMainJDBC3.class);
    public static void main(String[] args)  {

        Connection connection = null;
        try {
            Class.forName("org.h2.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:h2:/~/test", "sa", "");
            Statement stmt;

            String insertEmpleados = """
                INSERT INTO EMPLEADOS VALUES(3, 'Juan',28,'Digital','2022-03-04');
                INSERT INTO EMPLEADOS VALUES(4, 'Carlos',27,'Google','2022-03-10');
                INSERT INTO EMPLEADOS VALUES(5, 'Ivan',25,'Facebook','2022-02-08');
                INSERT INTO EMPLEADOS VALUES(5, 'Ivan',25,'Facebook','2022-02-08');        
                """;
            try {
                stmt = connection.createStatement();
                stmt.executeUpdate(insertEmpleados);
                logger.info("empleados insertados con exito en tabla empleados");
            }catch (Exception e){
                logger.error("Error al insertar empleados enla tabla Empleados",e);
            }

            String updateEmpleado = "UPDATE EMPLEADOS SET NAME='Rodrigo' WHERE ID=1";
            try {
                stmt = connection.createStatement();
                stmt.executeUpdate(updateEmpleado);
                logger.info("empleado Actualizado con exito");
            }catch (Exception e){
                logger.error("Error al Actualizar un empleado en la tabla Empleados",e);
            }

            String deleteEmpleadoByID = "DELETE FROM EMPLEADOS WHERE ID=1";
            try {
                stmt = connection.createStatement();
                stmt.executeUpdate(deleteEmpleadoByID);
                logger.info("Eliminacion de empleado segun id con exito");
            }catch (Exception e){
                logger.error("Error al Eliminar un empleado segun el ID",e);
            }

            String deleteEmpleadoByName = "DELETE FROM EMPLEADOS WHERE NAME='Ivan'";
            try {
                stmt = connection.createStatement();
                stmt.executeUpdate(deleteEmpleadoByName);
                logger.info("Eliminacion de empleado segun nombre con exito");
            }catch (Exception e){
                logger.error("Error al Eliminar un empleado segun el nombre",e);
            }


        } catch (Exception e) {
            logger.fatal("Error en la conexion a la base de datos",e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Error al cerrar la conexion a la BD", e);
            }
        }





        /*
        String queryEmpleados = "select * from EMPLEADOS";
        logger.info("Obteniendo los empleados de la Tabla Empleados");
        ResultSet results = stmt.executeQuery(queryEmpleados);

        logger.info("Creando Lista de Empleados");
        List<Empleado> empleados = new ArrayList<>();
        while (results.next()) {
            empleados.add(new Empleado(results.getLong(1),
                    results.getString(2),
                    results.getInt(3),
                    results.getString(4),
                    results.getDate(5)));
        }
        logger.info("Recorriendo la lista de empleados");
        System.out.println("Empleados: {");
        empleados.forEach((e) ->
                System.out.println("    " + e.getId() + "-" + e.getNombre()
                        + ", edad:" + e.getEdad()
                        + ", empresa:" + e.getEmpresa()
                        + ", fechaInicio:" + e.getFechaInicio()
                )
        );
        System.out.println("}");
        */

    }
}
