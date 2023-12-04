package com.example.biblioteca.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class Libro {

    private Integer id;
    private String isbn;

    private Integer ano;
    private Integer almacen_old;

    private Integer almacen_new;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getAlmacen_old() {
        return almacen_old;
    }

    public void setAlmacen_old(Integer almacen_old) {
        this.almacen_old = almacen_old;
    }

    public Integer getAlmacen_new() {
        return almacen_new;
    }

    public void setAlmacen_new(Integer almacen_new) {
        this.almacen_new = almacen_new;
    }
}
