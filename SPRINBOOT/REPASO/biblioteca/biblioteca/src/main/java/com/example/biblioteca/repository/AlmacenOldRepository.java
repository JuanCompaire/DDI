package com.example.biblioteca.repository;

import com.example.biblioteca.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlmacenOldRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(String nombre){
        jdbcTemplate.update("INSERT INTO ALMACEN_OLD (nombre) VALUES (?);", nombre);
    }

    public void update(String nombre, Integer id){
        jdbcTemplate.update("UPDATE ALMACEN_OLD SET nombre = ? WHERE id = ?;", nombre, id);
    }

    public void delete(Integer id){
        jdbcTemplate.update("DELETE FROM ALMACEN_OLD WHERE id = ?", new Object[]{id}); ;
    }

    public void deleteAll(){
        jdbcTemplate.update("DELETE FROM ALMACEN_OLD");
    }

    public List<AlmacenOld> findAll()
    {
        return jdbcTemplate.query("SELECT * FROM ALMACEN_OLD", new AlmacenOldRowMapper());
    }

    public AlmacenOld findById(long id){
        return jdbcTemplate.queryForObject("SELECT * FROM ALMACEN_OLD WHERE id = ?",
                new AlmacenOldRowMapper(), new Object[] {id});
    }

    public List<AlmacenOld> searchByNombre(String userInput){
        return jdbcTemplate.query("SELECT * FROM ALMACEN_OLD WHERE nombre LIKE ?",
                new AlmacenOldRowMapper(),userInput);
    }

    public List<AlmacenOld> getAlmacenOldByLibro(Libro libro){
        List<AlmacenOld> almacenOldList = jdbcTemplate.query(
                "SELECT a.id, a.nombre, l.id, l.isbn,l.ano FROM ALMACEN_OLD a, LIBRO l WHERE a.id = l.almacen_old AND l.id = ?",
                new AlmacenOldRowMapper(), libro.getId());
        return almacenOldList;

    }

}
