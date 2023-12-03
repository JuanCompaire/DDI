package com.example.biblioteca.controller;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LibroController {

    @Autowired
    LibroService service;

    @RequestMapping("/insertarLibro")
    public String insertarLibro(Libro libro, Model model) {
        List<Libro> lista = service.insertarLibro(libro);

        model.addAttribute("libros", lista);
        return "finLibro";

    }

    @RequestMapping("/updateLibroList/{id}")
    public String actualizarLibro(@PathVariable Integer id, Model model){
        Libro lib = service.updateLibroList(id);

        model.addAttribute("libro", lib);
        return "index";
    }

    @RequestMapping("/deleteLibro/{id}")
    public String borrarLibro(@PathVariable Integer id, Model model){
        List<Libro> lista = service.deleteLibro(id);

        model.addAttribute("libros", lista);
        return "finLibro";
    }

    @RequestMapping("/searchLibro")
    public String buscarLibro(@RequestParam("search") String userInput,Model model){
        List<Libro> lista = service.searchLibro(userInput);

        model.addAttribute("libros", lista);
        return "finLibro";
    }

    public Libro findLibroById(long id){
        Libro lib = service.searchLibroById(id);

        return lib;
    }
}
