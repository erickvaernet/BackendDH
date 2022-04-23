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
        DentistDTO dentistDTO1 = dentistService.save(new DentistDTO("asdas","nbmnbv","erick","vaernet",55555));
        DentistDTO dentistDTO2 = dentistService.save(
                new DentistDTO("ricky","vaernet","rick","vaernet",65555));
        PatientDTO patientDTO1 = patientService.save(
                new PatientDTO(1113,"24ick","Vnet","Erick","Vnet", LocalDate.now(),
                        new Address("callefalsa",123)));
        PatientDTO patientDTO2 = patientService.save(
                new PatientDTO(1113,"5t5Rick","Vnet","Rick","Vnet", LocalDate.now(),
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
                                    5113,"894Erick","Vnet","Erick","Vnet",LocalDate.now()
                                    ,new Address("callefalsa",23)
                            )
                    ),
                    dentistService.save(
                            new DentistDTO("924t2ck","vaernet2","rick","vaernet",6355)
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
                new PatientDTO(11100,"Ri352c18k","Vnet","Rick","Vnet", LocalDate.now(),
                        new Address("callefalsa",1021)));
        DentistDTO dentistDTO = dentistService.save(
                new DentistDTO("552ds","afa3","erick","vaernet",55761));
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
    void findAll() {
        List<AppointmentDTO> appointmentDTOList=appointmentService.findAll();
        assertNotNull(appointmentDTOList);
        assertTrue(appointmentDTOList.size()>0);
    }

    @Test
    void findByDentistId() {
        DentistDTO dentistDTO= dentistService.save(new DentistDTO("924232c7k","vaernet2","rick","vaernet",11103));
        AppointmentDTO appointmentDTO= appointmentService.save(
                new AppointmentDTO(
                        patientService.save(
                                new PatientDTO(
                                        51132,"894Er5ick","Vnet","Erick","Vnet",LocalDate.now()
                                        ,new Address("callefalsa",232)
                                )
                        ),
                        dentistService.save(
                                dentistDTO
                        ),
                        LocalDateTime.now()
                )
        );
        List<AppointmentDTO> appointmentDTOList=appointmentService.findByDentistId(dentistDTO.getId());
        assertNotNull(appointmentDTOList);
        assertTrue(appointmentDTOList.size()>0);
    }

    @Test
    void findByPatientId() {
        DentistDTO dentistDTO= new DentistDTO("920488k","vaernet2","rick","vaernet",100006);
        PatientDTO patientDTO= patientService.save(new PatientDTO(
                51132,"4i04fjak","Vnet","Erick","Vnet",LocalDate.now()
                ,new Address("callefalsa",00232)
        ));
        AppointmentDTO appointmentDTO= appointmentService.save(
                new AppointmentDTO(
                        patientService.save(
                                patientDTO
                        ),
                        dentistService.save(
                                dentistDTO
                        ),
                        LocalDateTime.now()
                )
        );
        List<AppointmentDTO> appointmentDTOList=appointmentService.findByPatientId(patientDTO.getId());
        assertNotNull(appointmentDTOList);
        assertTrue(appointmentDTOList.size()>0);
    }
    @Test
    void deleteById() {
        appointmentService.deleteById(1L);
        AppointmentDTO dto=null;
        try {
            dto=appointmentService.findById(1L);
        }
        catch (Exception e){
            assertTrue(e.getMessage().contains("Appointment not found"));
        }
        assertTrue(dto==null);
    }

}