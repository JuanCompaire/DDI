package com.example.biblioteca.controller;

import com.example.biblioteca.model.AlmacenNew;
import com.example.biblioteca.model.Libro;
import com.example.biblioteca.service.AlmacenNewService;
import com.example.biblioteca.service.AlmacenOldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    AlmacenOldService almacenOldService;

    @Autowired
    AlmacenNewService almacenNewService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("libro",new Libro());
        List< AlmacenNew > listaNuevos = almacenNewService.listarTodosAlmacenNew();
        model.addAttribute("almacenesNuevos", listaNuevos);
        List< AlmacenNew > listaOld = almacenNewService.listarTodosAlmacenNew();
        model.addAttribute("almacenesViejos", listaOld);
        return "index";
    }
}
