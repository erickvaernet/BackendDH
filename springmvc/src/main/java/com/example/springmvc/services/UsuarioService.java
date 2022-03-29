package com.example.springmvc.services;

import com.example.springmvc.dominio.Usuario;

public class UsuarioService {

    public Usuario crearUsuario(){
        Usuario u = new Usuario("Erick",25);
        return u;
    }
}
