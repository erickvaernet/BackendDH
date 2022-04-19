package com.example.integradorV2.Controllers;

import com.example.integradorV2.DTO.PatientDTO;
import com.example.integradorV2.Services.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    public PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable("id") Long id){
        return ResponseEntity.ok(patientService.findById(id));
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
        patientService.deleteById(id);
        return ResponseEntity.ok("Dentist deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updateOdontologo(@PathVariable Long id, @RequestBody PatientDTO dentist){
            return ResponseEntity.ok(patientService.update(id,dentist));
    }
}
