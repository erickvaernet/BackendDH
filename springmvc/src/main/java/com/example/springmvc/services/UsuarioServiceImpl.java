package com.example.springmvc.services;

import com.example.springmvc.dominio.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Override
    public Usuario create(String nombre,int edad) {
        Usuario u = new Usuario(nombre,edad);
        return u;
    }

    @Override
    public List<Usuario> list() {
        return Arrays.asList(
                new Usuario("Erick",25),
                new Usuario("Ian",26),
                new Usuario("Juan",27),
                new Usuario("Ivan",26)
                );
    }
}
