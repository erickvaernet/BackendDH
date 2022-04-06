package com.example.integrador.controller;

import com.example.integrador.domain.Domicilio;
import com.example.integrador.domain.Paciente;
import com.example.integrador.repository.Impl.DomicilioDaoH2;
import com.example.integrador.service.DomicilioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DomicilioController {
    DomicilioService domicilioService= new DomicilioService(new DomicilioDaoH2());

    @GetMapping("/crear-domicilio")
    public Domicilio createDomicilio(@RequestParam String calle, @RequestParam int numero,
                                     @RequestParam String localidad, @RequestParam String provincia)
    {
        return domicilioService.createDomicilio(new Domicilio(calle,numero,localidad,provincia));
    }

    @GetMapping("/listar-domicilios")
    public List<Domicilio> listDomicilio(){
        return domicilioService.list();
    }

    @GetMapping("/obtener-domicilio")
    public Domicilio getDomicilio(@RequestParam int id){
        return domicilioService.get(id);
    }

    @GetMapping("/eliminar-domicilio")
    public void deleteDomicilio(@RequestParam int id){
        domicilioService.delete(id);
    }

    @GetMapping("/actualizar-domicilio")
    public Domicilio createDomicilio(@RequestParam int id,@RequestParam String calle, @RequestParam int numero,
                                     @RequestParam String localidad, @RequestParam String provincia)
    {
        return domicilioService.update(new Domicilio(id,calle,numero,localidad,provincia));
    }
}










