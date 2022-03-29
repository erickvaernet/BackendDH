package com.company.DAO;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBH2Singleton {
    private static final Logger logger = Logger.getLogger(DBH2Singleton.class);
    private static DBH2Singleton instance;
    private Connection connection;
    private final String DB_JDBC_DRIVER="org.h2.Driver";
    private final String DB_USER="sa";
    private final String DB_PASSWORD="";

    private DBH2Singleton(String url) {
        try {
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection = DriverManager.getConnection(url,DB_USER,DB_PASSWORD);
            //crearTablas();
        } catch (Exception e) {
            logger.error("Error en la conexion a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (instance == null) instance = new DBH2Singleton("jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'");
        return instance.connection;
    }

    //Local al programa
    public static Connection getInMemoryConnection() {
        if (instance == null) instance = new DBH2Singleton("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM 'create.sql'");
        return instance.connection;
    }



}
