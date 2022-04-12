package com.example.integrador.controller;

import com.example.integrador.domain.Domicilio;
import com.example.integrador.domain.Paciente;
import com.example.integrador.repository.Impl.DomicilioDaoH2;
import com.example.integrador.repository.Impl.PacienteDaoH2;
import com.example.integrador.service.DomicilioService;
import com.example.integrador.service.PacienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PacienteController {
    PacienteService pacienteService= new PacienteService(new PacienteDaoH2());

    @GetMapping("/{id}")
    public Paciente getPaciente(@PathVariable int id){
        return pacienteService.get(id);
    }

    @GetMapping
    public List<Paciente> getPaciente(){
        return pacienteService.list();
    }

    /*
    @GetMapping("/crear-paciente")
    public Paciente createPaciente(@RequestParam String nombre,@RequestParam String apellido,){
        return pacienteService.create(nombre,apellido,);
    }
    */
}



















