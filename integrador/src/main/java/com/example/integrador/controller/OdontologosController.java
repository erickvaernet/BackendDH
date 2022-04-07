package com.example.integrador.controller;

import com.example.integrador.domain.Odontologo;
import com.example.integrador.repository.Impl.OdontologoDaoH2;
import com.example.integrador.service.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologosController {

    private OdontologoService odontologoService= new OdontologoService(new OdontologoDaoH2());

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Odontologo> getOdontologo(@PathVariable("id") int id){
        return ResponseEntity.ok(odontologoService.get(id));
    }

    @GetMapping("/listar")
    public ResponseEntity <List<Odontologo>> listOdontologos() {
        return ResponseEntity.ok(odontologoService.list());
    }

    @PostMapping("/registrar")
    public ResponseEntity<Odontologo> createOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.createOdontologo(odontologo));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> deleteOdontologo(@PathVariable int id){
        ResponseEntity<String> response=null;
        if(odontologoService.get(id)!=null){
            odontologoService.delete(id);
            response=ResponseEntity.ok("Eliminado");
        } else {
            response=ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Odontologo> updateOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.update(odontologo));
    }

}
