package com.example.integradorV2.Controllers;

import com.example.integradorV2.DTO.PatientDTO;
import com.example.integradorV2.DTO.PatientListDTO;
import com.example.integradorV2.Services.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    public PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable("id") Long id){
        PatientDTO dto= patientService.findById(id);
        dto.setPassword(null);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<PatientListDTO>> listPatient() {
        List<PatientListDTO> patientDTOList=new ArrayList<>();
        patientService.findAll().forEach((a)->
                patientDTOList.add(
                        new PatientListDTO(a.getId(),a.getDni(),
                                (a.getName()+" "+a.getLastName()),a.getAddress())));
        return ResponseEntity.ok(patientDTOList);
    }

    @PostMapping
    public ResponseEntity<PatientDTO> createOdontologo(@RequestBody PatientDTO odontologo){
        PatientDTO dto= patientService.save(odontologo);
        dto.setPassword(null);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOdontologo(@PathVariable Long id){
        patientService.deleteById(id);
        return ResponseEntity.ok("Dentist deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updateOdontologo(@PathVariable Long id, @RequestBody PatientDTO dentist){
        PatientDTO dto = patientService.update(id,dentist);
        dto.setPassword("******");
        return ResponseEntity.ok(dto);
    }
}
