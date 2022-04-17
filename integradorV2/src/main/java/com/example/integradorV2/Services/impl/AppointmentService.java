package com.example.integradorV2.Services.impl;

import com.example.integradorV2.DTO.AppointmentDTO;
import com.example.integradorV2.Persistence.IAppointmentRepository;
import com.example.integradorV2.Services.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {
    @Autowired
    private IAppointmentRepository appointmentRepository;


    @Override
    public AppointmentDTO save(AppointmentDTO obj) {
        return null;
    }

    @Override
    public AppointmentDTO update(Long id, AppointmentDTO obj) {
        return null;
    }

    @Override
    public AppointmentDTO findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<AppointmentDTO> findAll() {
        return null;
    }
}
