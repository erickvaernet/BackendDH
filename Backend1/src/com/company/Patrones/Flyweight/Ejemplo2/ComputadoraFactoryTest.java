package com.company.Patrones.Flyweight.Ejemplo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputadoraFactoryTest {

    public Computadora c1;

    @BeforeEach
    public void inicializar(){
        c1=ComputadoraFactory.getComputadora(10,200);
    }

    @Test
    public void comprobarReferencia(){
        assertEquals(c1,ComputadoraFactory.getComputadora(10,200));
    }

}