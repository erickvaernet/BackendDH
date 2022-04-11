package com.example.integrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class IntegradorApplication {
	private static final String DB_JDBC_DRIVER="org.h2.Driver";
	private static final String DB_URL_INIT="jdbc:h2:tcp://localhost/~/test;INIT=RUNSCRIPT FROM 'create.sql'";
	private static final String DB_USER="sa";
	private static final String DB_PASSWORD="";

	public static void cargarBD() {
		Connection cn=null;
		try {
			Class.forName(DB_JDBC_DRIVER);
			cn= DriverManager.getConnection(DB_URL_INIT,DB_USER,DB_PASSWORD);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				cn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(IntegradorApplication.class, args);
	}

}
