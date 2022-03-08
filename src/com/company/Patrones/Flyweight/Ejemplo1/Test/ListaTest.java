package com.company.Patrones.Flyweight.Ejemplo1.Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListaTest {

    public static Cancion c1;
    public static Cancion c2;

    @BeforeAll
    public static void BeforeTest() {
        c1= Lista.getCancion("cancion1");
        c1.setArista("artista1");
        c1.setGenero("Rock Nacional");

        c2= Lista.getCancion(c1.getNombre());
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