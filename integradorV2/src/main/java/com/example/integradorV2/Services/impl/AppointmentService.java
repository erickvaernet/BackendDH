package com.example.integradorV2.Services.impl;

import com.example.integradorV2.DTO.AppointmentDTO;
import com.example.integradorV2.DTO.DentistDTO;
import com.example.integradorV2.DTO.PatientDTO;
import com.example.integradorV2.Entities.Appointment;
import com.example.integradorV2.Exceptions.EntityNotFoundException;
import com.example.integradorV2.Exceptions.InvalidIdException;
import com.example.integradorV2.Exceptions.NullFieldsException;
import com.example.integradorV2.Persistence.IAppointmentRepository;
import com.example.integradorV2.Services.IAppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements IAppointmentService {
    @Autowired
    private IAppointmentRepository appointmentRepository;
    @Autowired
    private DentistService dentistService;
    @Autowired
    private  PatientService patientService;

    @Override
    public AppointmentDTO save(AppointmentDTO appointmentDTO) {
        if(appointmentDTO.getDateTime()==null
                || appointmentDTO.getPatient()==null
                || appointmentDTO.getDentist()==null)
        {
            throw new NullFieldsException(
                    "Some data of appointment like patient,dentist or dateTime is void");
        }
        //dentro de cada servicio se verifican si existen los turnos
        PatientDTO p =patientService.findById(appointmentDTO.getPatient().getId());
        DentistDTO d= dentistService.findById(appointmentDTO.getDentist().getId());

        Appointment newAppointment= mapToEntity(appointmentDTO);
        newAppointment=appointmentRepository.save(newAppointment);

        AppointmentDTO newAppointmentDTO =mapToDTO(newAppointment);
        newAppointmentDTO.setPatient(p);
        newAppointmentDTO.setDentist(d);

        return newAppointmentDTO;
    }

    @Override
    public AppointmentDTO update(Long id, AppointmentDTO appointmentDTO) {
        if(appointmentDTO==null)
            throw new NullFieldsException("Need an appointment");
        AppointmentDTO appointmentToUpdate=findById(id);
        Long patientId= appointmentDTO.getPatient().getId();
        Long dentistId=appointmentDTO.getDentist().getId();
        //Asignaciones
        if(appointmentDTO.getPatient()!=null)
            appointmentToUpdate.setPatient(
                    patientService.findById(patientId));
        if(appointmentDTO.getDentist()!=null)
            appointmentToUpdate.setDentist(
                    dentistService.findById(dentistId));
        if(appointmentDTO.getDateTime()!=null) appointmentToUpdate.setDateTime(appointmentDTO.getDateTime());
        //Guardado
        appointmentRepository.save(mapToEntity(appointmentToUpdate));
        return appointmentToUpdate;
    }

    @Override
    public AppointmentDTO findById(Long id) {
        if(id==null || id <= 0) throw new InvalidIdException("Appointment id cannot be 0, null or negative");
        Optional<Appointment> optionalAppointment= appointmentRepository.findById(id);
        return optionalAppointment.map(this::mapToDTO)
                .orElseThrow(()->new EntityNotFoundException("Appointment not found"));
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<AppointmentDTO> findAll() {
        List<AppointmentDTO> appointmentDTOList=new ArrayList<>();
        appointmentRepository.findAll()
                .forEach(
                        (appointment)->appointmentDTOList.add(mapToDTO( appointment ))
                );
        return appointmentDTOList;
    }

    @Override
    public List<AppointmentDTO> findByDentistId(long dentistId) {
        if(dentistId == 0) throw new InvalidIdException("Dentist id cannot be 0, null or negative");

        List<AppointmentDTO> appointmentDTOList=new ArrayList<>();
        appointmentRepository.findByDentistId(dentistId)
                .forEach(
                        (appointment)->appointmentDTOList.add(mapToDTO( appointment ))
                );
        return appointmentDTOList;
    }

    @Override
    public List<AppointmentDTO> findByPatientId(long patientId) {
        if(patientId == 0) throw new InvalidIdException("Patient id cannot be 0, null or negative");
        List<AppointmentDTO> appointmentDTOList=new ArrayList<>();
        appointmentRepository.findByPatientId(patientId)
                .forEach(
                        (appointment)->appointmentDTOList.add(mapToDTO( appointment ))
                );
        return appointmentDTOList;
    }

    //Mappers
    private AppointmentDTO mapToDTO(Appointment appointment){
        return new ObjectMapper().registerModule(new ParameterNamesModule()).
                registerModule(new Jdk8Module()).
                registerModule(new JavaTimeModule()).convertValue(appointment, AppointmentDTO.class);
    }
    private Appointment mapToEntity(AppointmentDTO appointmentDto){
        return new ObjectMapper().registerModule(new ParameterNamesModule()).
                registerModule(new Jdk8Module()).
                registerModule(new JavaTimeModule()).convertValue(appointmentDto, Appointment.class);
    }

}
