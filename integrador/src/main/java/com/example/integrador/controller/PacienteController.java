package com.example.integrador.controller;

import com.example.integrador.domain.Domicilio;
import com.example.integrador.domain.Paciente;
import com.example.integrador.domain.Turno;
import com.example.integrador.repository.Impl.DomicilioDaoH2;
import com.example.integrador.repository.Impl.PacienteDaoH2;
import com.example.integrador.service.DomicilioService;
import com.example.integrador.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPaciente(@PathVariable int id){
        return ResponseEntity.ok(pacienteService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listPaciente(){
        return ResponseEntity.ok(pacienteService.list());
    }

    @PostMapping
    public ResponseEntity<Paciente> postPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.createPaciente(paciente));
    }

    @PutMapping
    public  ResponseEntity<Paciente> putPaciente(@RequestBody Paciente paciente){
        ResponseEntity<Paciente> response=null;
        if(paciente.getId()>0) response=ResponseEntity.ok(pacienteService.update(paciente));
        else response= ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable int id){
        ResponseEntity<String> response=null;
        if(pacienteService.get(id)!=null){
            pacienteService.delete(id);
            response=ResponseEntity.ok("Eliminado");
        } else {
            response=ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    /*
    @GetMapping("/crear-paciente")
    public Paciente createPaciente(@RequestParam String nombre,@RequestParam String apellido,){
        return pacienteService.create(nombre,apellido,);
    }
    */
}



















