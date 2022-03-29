package com.example.springmvc.services;

import com.example.springmvc.dominio.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario create(String nombre,int edad);
    public List<Usuario> list();

}
