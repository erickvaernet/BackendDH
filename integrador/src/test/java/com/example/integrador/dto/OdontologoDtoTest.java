package com.example.integrador.dto;

import com.example.integrador.domain.Odontologo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoDtoTest {

    @Test
    public void odontologoDTO(){
        Odontologo odontologo=new Odontologo("asd","asdaf",134);
        ObjectMapper mapper= new ObjectMapper();
        OdontologoDto odontologoDto= mapper.convertValue(odontologo,OdontologoDto.class);
        Assertions.assertNotNull(odontologoDto);
    }

}