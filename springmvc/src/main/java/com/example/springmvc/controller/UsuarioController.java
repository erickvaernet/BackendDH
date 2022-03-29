package com.example.springmvc.controller;

import com.example.springmvc.dominio.Usuario;
import com.example.springmvc.services.UsuarioService;
import com.example.springmvc.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/crear")
    public Usuario crearUsuario(@RequestParam("nombre") String nombre, @RequestParam("edad") int edad){
        return usuarioService.create(nombre, edad);
    }

    @GetMapping("/listar")
    public List<Usuario> crearUsuario(){
        return usuarioService.list();
    }



}
