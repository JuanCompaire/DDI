package com.example.demo.controller;

import com.example.demo.model.Dueno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HelloController {

    @RequestMapping("/hola")
    public String hello(Model model){
        model.addAttribute("mensaje","hola desde thymeleaf");
        return "hola";
    }

    @RequestMapping("/")
    public String index(Model model){
        //necesario para que el formulario fucione
        model.addAttribute("dueno",new Dueno());
        // devuelve la pagina de index.html
        return "index";
    }
}
