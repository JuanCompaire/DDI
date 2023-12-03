package com.example.biblioteca.controller;

import com.example.biblioteca.model.AlmacenNew;
import com.example.biblioteca.model.AlmacenOld;
import com.example.biblioteca.service.AlmacenNewService;
import com.example.biblioteca.service.AlmacenOldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AlmacenController {

    @Autowired
    AlmacenOldService almacenOldService;

    @Autowired
    AlmacenNewService almacenNewService;

    @RequestMapping("/formAlmacen")
    public String formAlmacen(Model model) {
        model.addAttribute("nuevoAlmacen", new AlmacenNew());
        return "formAlmacen";
    }

    @RequestMapping("/insertAlmacen")
    public String insertAlmacen(@ModelAttribute("nuevoAlmacen") AlmacenNew almacenNew, BindingResult result, Model model, @RequestParam(name = "nueva", required = false, defaultValue = "false") boolean nueva) {
        if (nueva) {
            model.addAttribute("almacenesNuevos", almacenNewService.insertAlmacenNew(almacenNew));
            model.addAttribute("almacenesViejos", almacenOldService.listarTodosAlmacenOld());
        } else {
            AlmacenOld almacenOld = new AlmacenOld();
            almacenOld.setId(almacenNew.getId());
            almacenOld.setNombre(almacenNew.getNombre());
            model.addAttribute("almacenesViejos", almacenOldService.insertAlmacenOld(almacenOld));
            model.addAttribute("almacenesNuevos", almacenNewService.listarTodosAlmacenNew());
        }
        return "index";
    }
}

