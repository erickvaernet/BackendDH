package com.example.integradorV2.Controllers;

import com.example.integradorV2.DTO.DentistDTO;
import com.example.integradorV2.Exceptions.InvalidIdException;
import com.example.integradorV2.Services.impl.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/dentists")
public class DentistController {
    @Autowired
    private DentistService dentistService;

    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> getDentist(@PathVariable("id") Long id){
        DentistDTO dto=dentistService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<DentistDTO>> listDentist() {
        return ResponseEntity.ok(dentistService.findAll());
    }

    @PostMapping
    public ResponseEntity<DentistDTO> createOdontologo(@RequestBody DentistDTO odontologo){
        return ResponseEntity.ok(dentistService.save(odontologo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOdontologo(@PathVariable Long id){
        ResponseEntity<String> response;
        if(id==null || id<=0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        if(dentistService.findById(id)!=null){
            dentistService.deleteById(id);
            response=ResponseEntity.ok("Dentista eliminado");
        } else {
            response=ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<DentistDTO> updateOdontologo(@PathVariable Long id,@RequestBody DentistDTO dentist){
        System.out.println(id);
        System.out.println(dentist.toString());
        try {
            return ResponseEntity.ok(dentistService.update(id,dentist));
        }catch (Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return  null;
    }

}
