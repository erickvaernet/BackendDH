package com.company.JDBC2.Ejemplo1;

import java.sql.*;

public class Test {
    private static final String SQL_CREATE_TABLE="""
    DROP TABLE IF EXISTS USUARIO; CREATE TABLE USUARIO
    (
        ID INT PRIMARY KEY,
        NOMBRE varchar(100) NOT NULL,
        EMAIL varchar(100) NOT NULL,
        SUELDO numeric(15,2) NOT NULL
    )
    """;
    private static final String SQL_INSERT="INSERT INTO USUARIO (ID,NOMBRE,EMAIL,SUELDO) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE USUARIO SET SUELDO=? WHERE EMAIL=?";

    public static void main(String[] args) {
        Usuario u1= new Usuario("Erick","erick@mail.com",10000);
        Connection connection=null;

        try {
            connection=getConnection();
            Statement createTable= connection.createStatement();
            createTable.execute(SQL_CREATE_TABLE);

            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1,1);
            psInsert.setString(2,u1.getNombre());
            psInsert.setString(3,u1.getEmail());
            psInsert.setDouble(4,u1.getSueldo());
            psInsert.execute();

            //Empezar transaccion
            connection.setAutoCommit(false);

            PreparedStatement psUpdate= connection.prepareStatement(SQL_UPDATE);
            psUpdate.setDouble(1,u1.subirSueldo(3000));
            psUpdate.setString(2,u1.getEmail());
            psUpdate.execute();

            connection.commit();
            connection.setAutoCommit(true);

            String sql="SELECT * FROM USUARIO";
            Statement stmt =connection.createStatement();
            ResultSet rs= stmt.executeQuery(sql);

            while (rs.next()){
                System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getDouble(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
            if(connection!=null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();                }
            }
        }


    }

    private static final Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:/~/test","sa","");
    }

}
