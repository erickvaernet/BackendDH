package com.example.integradorV2;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@SpringBootApplication
public class IntegradorV2Application {

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(IntegradorV2Application.class, args);
		firstData();
	}


	private static void firstData(){
		try {
			Class.forName("org.h2.Driver").newInstance();
			Connection cn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			Statement stm=cn.createStatement();
			stm.executeUpdate("INSERT INTO USERS (username, password, role, name, last_name) VALUES ('admin', 'admin', 0, 'Usuario', 'Administrador'), ('dentist', 'dentist', 1, 'User', 'Dentist'), ('patient', 'patient', 2, 'USer', 'Patient')");
			stm.executeUpdate("INSERT INTO DENTISTS (id, license_number) VALUES (2, 7979);");
			stm.executeUpdate("INSERT INTO ADDRESSES (street, number) VALUES ('Av. Belgrano', 970);");
			stm.executeUpdate("INSERT INTO PATIENTS (id, dni, entry_date, address_id) VALUES (3, 2767876, current_timestamp, 1);");
			stm.executeUpdate("INSERT INTO APPOINTMENTS (date_time, dentist_id, patient_id) VALUES ('2021-10-14T20:00', 2, 3);");
			stm.close();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
