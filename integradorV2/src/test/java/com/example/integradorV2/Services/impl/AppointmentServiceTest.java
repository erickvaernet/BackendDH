package com.example.integradorV2.Services.impl;

import com.example.integradorV2.DTO.AppointmentDTO;
import com.example.integradorV2.DTO.DentistDTO;
import com.example.integradorV2.DTO.PatientDTO;
import com.example.integradorV2.Entities.Address;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppointmentServiceTest {
    @Autowired
    public  AppointmentService appointmentService;
    @Autowired
    public  DentistService dentistService;
    @Autowired
    public  PatientService patientService;

    @BeforeAll
    void data(){
        DentistDTO dentistDTO1 = dentistService.save(new DentistDTO(55555,"erick","vaernet"));
        DentistDTO dentistDTO2 = dentistService.save(
                new DentistDTO(65555,"rick","vaernet"));
        PatientDTO patientDTO1 = patientService.save(
                new PatientDTO(1113,"Erick","Vnet","e@mail.com", LocalDate.now(),
                        new Address("callefalsa",123)));
        PatientDTO patientDTO2 = patientService.save(
                new PatientDTO(1113,"Rick","Vnet","rv@mail.com", LocalDate.now(),
                        new Address("callefalsa",321)));

        appointmentService.save(new AppointmentDTO(patientDTO1,dentistDTO1,LocalDateTime.now()));
        appointmentService.save(new AppointmentDTO(patientDTO2,dentistDTO2,LocalDateTime.now()));

    }


    @Test
    void save() {
        AppointmentDTO appointmentDTO= appointmentService.save(
                new AppointmentDTO(
                    patientService.save(
                            new PatientDTO(
                                    5113,"Erick","Vnet","e@mail.com",LocalDate.now()
                                    ,new Address("callefalsa",23)
                            )
                    ),
                    dentistService.save(
                            new DentistDTO(6355,"rick","vaernet")
                    ),
                    LocalDateTime.now()
                )
        );
        assertNotNull(appointmentDTO);
        assertTrue(appointmentDTO.getId()>0);
    }

    @Test
    void findById() {
        AppointmentDTO dt=appointmentService.findById(1L);
        assertNotNull(dt);
        assertTrue(dt.getId()>0);
    }

    @Test
    void update() {
        //datos
        PatientDTO patientDTO = patientService.save(
                new PatientDTO(11100,"Rick","Vnet","rv@mail.com", LocalDate.now(),
                        new Address("callefalsa",1021)));
        DentistDTO dentistDTO = dentistService.save(
                new DentistDTO(55761,"erick","vaernet"));
        LocalDateTime localDateTime = LocalDateTime.now();

        //crear nuevo appointment y guardarlo
        AppointmentDTO appointmentDTO = appointmentService.save(
                new AppointmentDTO( patientDTO, dentistDTO, localDateTime)
        );
        //Asignar nueva fecha/hora para el turno
        LocalDateTime localDateTimeUpdated = LocalDateTime.now().plusDays(1);
        appointmentDTO.setDateTime(localDateTimeUpdated);
        //Obtenemos ID
        long appointmentDTOId = appointmentDTO.getId();
        //Actualizamos
        appointmentService.update(appointmentDTOId,appointmentDTO);

        //Verificacion
        AppointmentDTO dto=appointmentService.findById(appointmentDTOId);
        assertEquals(dto.getDateTime().withNano(0),localDateTimeUpdated.withNano(0));
        assertEquals(dto.getDentist().toString(),dentistDTO.toString());
        assertEquals(dto.getPatient().toString(),patientDTO.toString());
    }

    @Test
    void deleteById() {
        appointmentService.deleteById(1L);
        try {
            AppointmentDTO dto=appointmentService.findById(1L);
        }
        catch (Exception e){
            assertTrue(e.getMessage().contains("Appointment not found"));
        }
    }

    @Test
    void findAll() {
        List<AppointmentDTO> appointmentDTOList=appointmentService.findAll();
        assertNotNull(appointmentDTOList);
        assertTrue(appointmentDTOList.size()>0);
    }

    @Test
    void findByDentistId() {
        List<AppointmentDTO> appointmentDTOList=appointmentService.findByDentistId(1L);
        assertNotNull(appointmentDTOList);
        assertTrue(appointmentDTOList.size()>0);
    }

    @Test
    void findByPatientId() {
        List<AppointmentDTO> appointmentDTOList=appointmentService.findByPatientId(1L);
        assertNotNull(appointmentDTOList);
        assertTrue(appointmentDTOList.size()>0);
    }

}