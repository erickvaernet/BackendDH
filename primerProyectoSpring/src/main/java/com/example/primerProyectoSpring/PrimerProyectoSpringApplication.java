package com.example.primerProyectoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@SpringBootApplication
@RestController
public class PrimerProyectoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimerProyectoSpringApplication.class, args);
	}

	@GetMapping
	public String holaMundo(){
		Instant now= Instant.now();
		return "<h1>Hola mundo!</h1>" +
				"<p>Primera aplicacion en Spring</p>"+
				"<p>El momento actuala es "+now+" </p>";
	}
}
