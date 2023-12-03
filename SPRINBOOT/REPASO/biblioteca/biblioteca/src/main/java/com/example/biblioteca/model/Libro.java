package com.example.biblioteca.model;


import lombok.Data;
import lombok.Getter;

import java.util.Date;


@Getter
@Data
public class Libro {

    private int id;
    private String isbn;

    private Date fechaEdicion;

    private int almacen_old;

    private int almacen_new;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public int getAlmacen_old() {
        return almacen_old;
    }

    public void setAlmacen_old(int almacen_old) {
        this.almacen_old = almacen_old;
    }

    public int getAlmacen_new() {
        return almacen_new;
    }

    public void setAlmacen_new(int almacen_new) {
        this.almacen_new = almacen_new;
    }
}
