package com.company.JDBC;

import java.sql.*;

public class TestMainJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con;
        Statement stmt;
        try {
            con = DriverManager.getConnection("jdbc:h2:"+
                    "./Database/my", "root", "myPassword");
            stmt = con.createStatement();

            //Código para crear una tabla. Elimina la tabla si esta ya existe y la
            //vuelve a crear
            String createSql = """
                    DROP TABLE IF EXISTS TEST;
                    CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255));
                    INSERT INTO TEST VALUES(1, 'Hello');
                    INSERT INTO TEST VALUES(2, 'World');
                    """;
            stmt.execute(createSql);

            //Codigo para consultar todos los registros de la tabla TEST
            String sql = "select * from TEST";
            ResultSet rd = stmt.executeQuery(sql);
            //Código para recorrer el resultado de la consulta
            while(rd.next()) {
                System.out.println(rd.getInt(1) + rd.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
