package com.company.Patrones.Flyweight.Ejemplo1.Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListaTest {

    public  Cancion c1;
    public  Cancion c2;

    @BeforeEach
    public void BeforeTest() {
        c1= Lista.getCancion("cancion1","artista1","genero1");
        c2= Lista.getCancion(c1.getNombre(),c1.getArista(),c1.getGenero());
    }

    @Test
    public void CancionReferenciaTest() {
        //assertEquals("cancion1",Lista.getCancion("cancion1").getNombre());
        //assertEquals(c1,Lista.getCancion(c1.getNombre()));
        assertEquals(c1,c2);
    }

    @Test
    public void MismoArtistaTest() {
        assertEquals(c1.getArista(),c2.getArista());
    }

    @Test
    public void MismoGeneroTest() {
        assertEquals(c1.getGenero(),c2.getGenero());
    }
}