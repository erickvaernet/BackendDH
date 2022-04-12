package com.example.integrador.controller;

import com.example.integrador.domain.Turno;
import com.example.integrador.repository.Impl.OdontologoDaoH2;
import com.example.integrador.repository.Impl.PacienteDaoH2;
import com.example.integrador.repository.Impl.TurnosListaDaoH2;
import com.example.integrador.service.OdontologoService;
import com.example.integrador.service.PacienteService;
import com.example.integrador.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) {
        ResponseEntity<Turno> response;
        if (pacienteService.get(turno.getPaciente().getId()) != null && odontologoService.get(turno.getOdontologo().getId()) != null)
            response = ResponseEntity.ok(turnoService.registrarTurno(turno));
        else
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listar() {
        return ResponseEntity.ok(turnoService.list());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id){
        if(turnoService.getTurno(id)==null){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe el turno a eliminar");
        }
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok("Eliminado");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> getTurno(@PathVariable int id){
        return ResponseEntity.ok(turnoService.getTurno(id));
    }

    @PutMapping
    public ResponseEntity<Turno> updateTurno(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.updateTurno(turno));
    }
}
