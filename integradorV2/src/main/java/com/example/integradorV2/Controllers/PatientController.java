package com.example.integradorV2.Controllers;

import com.example.integradorV2.DTO.PatientDTO;
import com.example.integradorV2.Services.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    public PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable("id") Long id){
        if(id==null || id<=0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        PatientDTO dto=patientService.findById(id);
        if(dto!=null) return ResponseEntity.ok(dto);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> listPatient() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @PostMapping
    public ResponseEntity<PatientDTO> createOdontologo(@RequestBody PatientDTO odontologo){
        return ResponseEntity.ok(patientService.save(odontologo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOdontologo(@PathVariable Long id){
        ResponseEntity<String> response;
        if(id==null || id<=0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        if(patientService.findById(id)!=null){
            patientService.deleteById(id);
            response=ResponseEntity.ok("Dentista eliminado");
        } else {
            response=ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updateOdontologo(@PathVariable Long id, @RequestBody PatientDTO dentist){
        System.out.println(id);
        System.out.println(dentist.toString());
        try {
            return ResponseEntity.ok(patientService.update(id,dentist));
        }catch (Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return  null;
    }
}
