package com.example.odontologo.service;

import com.example.odontologo.domain.Odontologo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OdontologoServiceImpl implements OdontologoService{

    @Override
    public List<Odontologo> list() {
        return Arrays.asList(new Odontologo("Erick"), new Odontologo("Ian"));
    }
}
