package com.example.springmvc.controller;

import com.example.springmvc.dominio.Usuario;
import com.example.springmvc.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UsuarioController {
    private UsuarioService usuarioService= new UsuarioService();


    @GetMapping("/crear")
    @ResponseBody
    public Usuario crearUsuario(){
        return usuarioService.crearUsuario();
    }

    @GetMapping("/crear2")
    @ResponseBody
    public Usuario crearUsuario2(@RequestParam("edad") int edadUsuario){
        return new Usuario("Ian",edadUsuario);
    }


}
