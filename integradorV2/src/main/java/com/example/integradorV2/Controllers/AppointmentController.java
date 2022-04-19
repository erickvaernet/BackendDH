package com.example.integradorV2.Controllers;

import com.example.integradorV2.DTO.AppointmentDTO;
import com.example.integradorV2.Exceptions.EntityNotFoundException;
import com.example.integradorV2.Services.impl.AppointmentService;
import com.example.integradorV2.Services.impl.DentistService;
import com.example.integradorV2.Services.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    public AppointmentService appointmentService;
    @Autowired
    public DentistService dentistService;
    @Autowired
    public PatientService patientService;


    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable("id") Long id){
        AppointmentDTO dto=appointmentService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> listAppointment() {
        return ResponseEntity.ok(appointmentService.findAll());
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<List<AppointmentDTO>> listAppointmentsByPatient(@PathVariable long id) {
        return ResponseEntity.ok(appointmentService.findByPatientId(id));
    }
    @GetMapping("/dentist/{id}")
    public ResponseEntity<List<AppointmentDTO>> listAppointmentsByDentist(@PathVariable long id) {
        return ResponseEntity.ok(appointmentService.findByDentistId(id));
    }

    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody AppointmentDTO appointment){
        //Quitamos los ms = Ponemos los milisegundos a 0
        appointment.setDateTime(appointment.getDateTime().withNano(0));
        //Se guarda y retorna
        return ResponseEntity.ok(appointmentService.save(appointment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id){
        appointmentService.deleteById(id);
        return ResponseEntity.ok("Appointment deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable Long id, @RequestBody AppointmentDTO dentist){
        return ResponseEntity.ok(appointmentService.update(id,dentist));
    }
}
