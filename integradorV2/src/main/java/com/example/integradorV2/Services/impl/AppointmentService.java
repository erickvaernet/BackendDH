package com.example.integradorV2.Services.impl;

import com.example.integradorV2.DTO.AppointmentDTO;
import com.example.integradorV2.DTO.DentistDTO;
import com.example.integradorV2.Entities.Appointment;
import com.example.integradorV2.Entities.Dentist;
import com.example.integradorV2.Persistence.IAppointmentRepository;
import com.example.integradorV2.Services.IAppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements IAppointmentService {
    @Autowired
    private IAppointmentRepository appointmentRepository;


    @Override
    public AppointmentDTO save(AppointmentDTO appointmentDTO) {
        Appointment newAppointment= mapToEntity(appointmentDTO);
        newAppointment=appointmentRepository.save(newAppointment);
        return mapToDTO(newAppointment);
    }

    @Override
    public AppointmentDTO update(Long id, AppointmentDTO appointmentDTO) {
        AppointmentDTO appointmentToUpdate=findById(id);
        //Comprobaciones
        if(appointmentDTO==null || appointmentToUpdate==null) return null;
        //Asignaciones
        if(appointmentDTO.getPatient()!=null) appointmentToUpdate.setPatient(appointmentDTO.getPatient());
        if(appointmentDTO.getDentist()!=null) appointmentToUpdate.setDentist(appointmentDTO.getDentist());
        if(appointmentDTO.getDateTime()!=null) appointmentToUpdate.setDateTime(appointmentDTO.getDateTime());
        //Guardado
        appointmentRepository.save(mapToEntity(appointmentToUpdate));
        return appointmentToUpdate;
    }

    @Override
    public AppointmentDTO findById(Long id) {
        Optional<Appointment> optionalAppointment= appointmentRepository.findById(id);
        return optionalAppointment.map(this::mapToDTO).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
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

    //Mappers
    private AppointmentDTO mapToDTO(Appointment appointment){
        return new ObjectMapper().convertValue(appointment, AppointmentDTO.class);
    }
    private Appointment mapToEntity(AppointmentDTO appointmentDto){
        return new ObjectMapper().convertValue(appointmentDto, Appointment.class);
    }
}
