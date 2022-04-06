package com.example.demoSpringTemplate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PacienteController {

    @RequestMapping(value = "/i",method = RequestMethod.GET)
    public String welcome(Model model) {
        model.addAttribute("nombre", "diez");
        model.addAttribute("apellido", "diez");
        return "i";
    }
}
