package com.example.integradorV2.Controllers;

import com.example.integradorV2.DTO.DentistDTO;
import com.example.integradorV2.Services.impl.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    @Autowired
    private DentistService dentistService;

    @GetMapping("/{id}")
    @ResponseBody
    public DentistDTO getDentist(@PathVariable Long id){
        return dentistService.findById(id);
    }
    @GetMapping
    public ResponseEntity<List<DentistDTO>> listDentist() {
        return ResponseEntity.ok(dentistService.findAll());
    }

    @PostMapping
    public ResponseEntity<DentistDTO> createOdontologo(@RequestBody DentistDTO odontologo){
        return ResponseEntity.ok(dentistService.save(odontologo));
    }

}
