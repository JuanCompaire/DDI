package com.example.demo.model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MascotaRowMapper implements RowMapper<Mascota> {

    @Override

    public Mascota mapRow(ResultSet rs, int numRow) throws SQLException{
        Dueno dueno = new Dueno();
        dueno.setId(rs.getInt("id"));
        dueno.setNombre(rs.getString("nombre"));


        Mascota mascota = new Mascota();
        mascota.setId(rs.getInt("id"));
        mascota.setNombre(rs.getString("nombre"));
        mascota.setNum_chip(rs.getInt("num_chip"));
        mascota.setVacunado(rs.getBoolean("vacunado"));
        return mascota;
    }
}
