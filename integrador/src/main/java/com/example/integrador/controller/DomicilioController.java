package com.example.integrador.controller;

import com.example.integrador.domain.Domicilio;
import com.example.integrador.repository.Impl.DomicilioDaoH2;
import com.example.integrador.service.DomicilioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {
    DomicilioService domicilioService= new DomicilioService(new DomicilioDaoH2());

   /* @PostMapping("/crear-domicilio")
    public Domicilio createDomicilio(@RequestParam String calle, @RequestParam int numero,
                                     @RequestParam String localidad, @RequestParam String provincia)
    {
        return domicilioService.createDomicilio(new Domicilio(calle,numero,localidad,provincia));
    }*/

    @PostMapping("/registrar")
    public ResponseEntity<Domicilio> createDomicilio(@RequestBody Domicilio domicilio)
    {
        System.out.println(domicilio);
        return ResponseEntity.ok(domicilioService.createDomicilio(domicilio));
    }

    @GetMapping("/listar")
    @ResponseBody
    public ResponseEntity<List<Domicilio>> listDomicilio(){
        return ResponseEntity.ok(domicilioService.list());
    }

    @GetMapping("/obtener/{id}")
    @ResponseBody
    public ResponseEntity<Domicilio> getDomicilio(@PathVariable("id") int id){
        return ResponseEntity.ok(domicilioService.get(id));
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteDomicilio(@PathVariable("id") int id){
        domicilioService.delete(id);
    }

    @DeleteMapping("/eliminar")
    public String deleteDomicilio(@RequestParam int firstId, @RequestParam int lastId){
        domicilioService.deleteFromTo(firstId,lastId);
        return "Bien";
    }

    @PutMapping("/actualizar-domicilio")
    public ResponseEntity<Domicilio> actualizarDomicilio(@RequestBody Domicilio domicilio)
    {
        ResponseEntity<Domicilio> response;

        if(domicilio.getId() > 0 && domicilioService.get(domicilio.getId()) != null)
            response=ResponseEntity.ok(domicilioService.update(domicilio));
        else
            response=ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
}










