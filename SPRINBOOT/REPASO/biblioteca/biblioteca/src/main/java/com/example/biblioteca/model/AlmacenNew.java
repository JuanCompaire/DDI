package com.example.biblioteca.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AlmacenNew {
    private Integer id;
    private String nombre;

    private Libro libro;

    public Libro getLibro() {
        return libro;
    }

    public AlmacenNew(String nombre, Libro libro) {
        this.nombre = nombre;
        this.libro = libro;
    }

    public AlmacenNew() {
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
