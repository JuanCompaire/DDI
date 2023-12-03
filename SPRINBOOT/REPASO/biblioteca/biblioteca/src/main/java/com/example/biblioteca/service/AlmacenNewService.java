package com.example.biblioteca.service;

import com.example.biblioteca.model.AlmacenNew;
import com.example.biblioteca.repository.AlmacenNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlmacenNewService {

    @Autowired
    AlmacenNewRepository almacenNewRepository;

    public List<AlmacenNew> insertAlmacenNew(AlmacenNew almacenNew) {
        System.out.println("id: " + almacenNew.getId() + " nombre: " + almacenNew.getNombre());
        //Si no tiene id, entonces es un registro nuevo
        if (almacenNew.getId() == null) {
            almacenNewRepository.insert(almacenNew);
        } else {
            almacenNewRepository.update(almacenNew);
        }
        List<AlmacenNew> lista = almacenNewRepository.findAll();
        for (AlmacenNew a : lista) {
            System.out.println("id: " + a.getId() + " nombre: " + a.getNombre());
        }

        return lista;
    }

    public AlmacenNew updateAlmacenNewList(Integer id) {
        AlmacenNew almacenNew = almacenNewRepository.findById(id);

        System.out.print(almacenNew.getNombre());
        return almacenNew;
    }

    public List<AlmacenNew> deleteAlmacenNew(Integer id) {
        almacenNewRepository.delete(id);

        List<AlmacenNew> lista = almacenNewRepository.findAll();
        return lista;

    }

    public List<AlmacenNew> searchAlmacenNew(String userInput) {
        List<AlmacenNew> lista = almacenNewRepository.searchByNombre(userInput);
        for (AlmacenNew a : lista) {
            System.out.println("id: " + a.getId() + " nombre: " + a.getNombre());
        }
        return lista;
    }

    public AlmacenNew searchById(long id) {
        return almacenNewRepository.findById(id);
    }
}
