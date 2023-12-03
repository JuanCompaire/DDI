package com.example.biblioteca.controller;

import com.example.biblioteca.model.AlmacenNew;
import com.example.biblioteca.model.AlmacenOld;
import com.example.biblioteca.repository.AlmacenNewRepository;
import com.example.biblioteca.repository.AlmacenOldRepository;
import com.example.biblioteca.service.AlmacenNewService;
import com.example.biblioteca.service.AlmacenOldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.biblioteca.model.AlmacenOld;

@Controller
public class AlmacenController {

    @Autowired
    AlmacenOldService almacenOldRepository;

    @Autowired
    AlmacenNewService almacenNewRepository;

    @RequestMapping("/formAlmacen")
    public String formAlmacen(Model model){
        model.addAttribute("nuevoAlmacen", new AlmacenNew());
        return "formAlmacen";
    }

    @RequestMapping("/insertarAlmacen")
    public String insertarAlmacen(AlmacenNew almacenNew, @RequestParam(name = "nueva", required = false,
    defaultValue = "false") boolean nueva){
        if(nueva == true){
            almacenNewRepository.insertAlmacenNew(almacenNew);
        }
        else{
            AlmacenOld almacenOld = new AlmacenOld();
            almacenOld.setNombre(almacenNew.getNombre());
            almacenOldRepository.insertAlmacenOld(almacenOld);
        }
        return "index";
    }
}
