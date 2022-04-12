package com.example.integrador.controller;

import com.example.integrador.domain.Odontologo;
import com.example.integrador.repository.Impl.OdontologoDaoH2;
import com.example.integrador.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologosController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> getOdontologo(@PathVariable("id") int id){
        return ResponseEntity.ok(odontologoService.get(id));
    }

    @GetMapping
    public ResponseEntity <List<Odontologo>> listOdontologos() {
        return ResponseEntity.ok(odontologoService.list());
    }

    @PostMapping
    public ResponseEntity<Odontologo> createOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.createOdontologo(odontologo));
    }

    @DeleteMapping("/{id}")
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

    @PutMapping
    public ResponseEntity<Odontologo> updateOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.update(odontologo));
    }

}
