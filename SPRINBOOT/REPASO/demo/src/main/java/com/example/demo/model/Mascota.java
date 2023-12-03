package com.example.demo.model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Mascota {
    private Integer id;

    private Integer num_chip;

    private String nombre;

    private  Boolean vacunado;

    private Dueno dueno;

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    public Mascota(int num_chip, String nombre, Boolean vacunado, Dueno dnidueno) {
        this.num_chip = num_chip;
        this.nombre = nombre;
        this.vacunado = vacunado;
        this.dueno = dnidueno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum_chip() {
        return num_chip;
    }

    public void setNum_chip(Integer num_chip) {
        this.num_chip = num_chip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getVacunado() {
        return vacunado;
    }

    public void setVacunado(Boolean vacunado) {
        this.vacunado = vacunado;
    }
}
