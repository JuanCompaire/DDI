package com.example.biblioteca.controller;

import com.example.biblioteca.model.AlmacenNew;
import com.example.biblioteca.model.Libro;
import com.example.biblioteca.service.AlmacenNewService;
import com.example.biblioteca.service.AlmacenOldService;
import com.example.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    LibroService libroService;

    @Autowired
    AlmacenOldService almacenOldService;

    @Autowired
    AlmacenNewService almacenNewService;

    @RequestMapping("/")
    public String index(Model model){
        cargarListas(model);
        return "index";
    }

    @RequestMapping("/finalmacen")
    public String finalmacen(Model model){
        cargarListas(model);
        return "finalmacen";
    }

    @RequestMapping("/finlibro")
    public String finlibro(Model model){
        cargarListas(model);
        return "finlibro";
    }

    private void cargarListas(Model model) {
        List<Libro> listaLibros = libroService.listarTodosLibro();
        model.addAttribute("libros", listaLibros);
        List< AlmacenNew > listaNuevos = almacenNewService.listarTodosAlmacenNew();
        model.addAttribute("almacenesNuevos", listaNuevos);
        List< AlmacenNew > listaOld = almacenNewService.listarTodosAlmacenNew();
        model.addAttribute("almacenesViejos", listaOld);
    }


}
