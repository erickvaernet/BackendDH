package com.example.integradorV2.Controllers;

import com.example.integradorV2.DTO.DentistDTO;
import com.example.integradorV2.DTO.DentistListDTO;
import com.example.integradorV2.Entities.Role;
import com.example.integradorV2.Services.impl.DentistService;
import com.example.integradorV2.Services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/dentists")
public class DentistController {
    @Autowired
    private DentistService dentistService;
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> getDentist(@PathVariable("id") Long id){
        DentistDTO dto=dentistService.findById(id);
        dto.setPassword(null);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<DentistListDTO>> listDentist() {
        List<DentistListDTO> dentistListDTOS=new ArrayList<>();
        dentistService.findAll().stream().forEach((a)->
                dentistListDTOS.add(
                        new DentistListDTO(a.getId(),a.getLicenseNumber(),
                                (a.getName()+" "+a.getLastName()))));
        return ResponseEntity.ok(dentistListDTOS);
    }

    @PostMapping
    public ResponseEntity<DentistDTO> saveDentist(@RequestBody DentistDTO newDentist){
        newDentist.setRole(Role.DENTIST);
        DentistDTO dto=dentistService.save(newDentist);
        dto.setPassword(null);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOdontologo(@PathVariable Long id){
        ResponseEntity<String> response;

        if(dentistService.findById(id)!=null){
            dentistService.deleteById(id);
            response=ResponseEntity.ok("Dentist deleted");
        } else {
            response=ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<DentistDTO> updateOdontologo(@PathVariable Long id,@RequestBody DentistDTO dentist){
        System.out.println(id);
        System.out.println(dentist.toString());
        dentistService.update(id,dentist);
        DentistDTO dto= dentistService.findById(id);
        dto.setPassword(null);
        return ResponseEntity.ok(dto);
    }

}
