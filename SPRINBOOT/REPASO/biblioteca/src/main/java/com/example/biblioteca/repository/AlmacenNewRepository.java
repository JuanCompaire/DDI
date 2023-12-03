package com.example.biblioteca.repository;

import com.example.biblioteca.model.AlmacenNew;
import com.example.biblioteca.model.AlmacenNewRowMapper;
import com.example.biblioteca.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlmacenNewRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(AlmacenNew almacenNew){
        jdbcTemplate.update("INSERT INTO ALMACEN_NEW (nombre) VALUES (?);", almacenNew.getNombre());
    }

    public void update(AlmacenNew almacenNew){
        jdbcTemplate.update("UPDATE ALMACEN_NEW SET nombre = ? WHERE id = ?;", almacenNew.getNombre(), almacenNew.getId());
    }

    public void delete(Integer id){
        jdbcTemplate.update("DELETE FROM ALMACEN_NEW WHERE id = ?", new Object[]{id}); ;
    }

    public void deleteAll(){
        jdbcTemplate.update("DELETE FROM ALMACEN_NEW");
    }

    public List<AlmacenNew> findAll()
    {
        return jdbcTemplate.query("SELECT * FROM ALMACEN_NEW", new AlmacenNewRowMapper());
    }

    public AlmacenNew findById(long id){
        return jdbcTemplate.queryForObject("SELECT * FROM ALMACEN_NEW WHERE id = ?",
                new AlmacenNewRowMapper(), new Object[] {id});
    }

    public List<AlmacenNew> searchByNombre(String userInput){
        return jdbcTemplate.query("SELECT * FROM ALMACEN_NEW WHERE nombre LIKE ?",
                new AlmacenNewRowMapper(),userInput);
    }

    public List<AlmacenNew> getAlmacenNewByLibro(Libro libro){
        List<AlmacenNew> almacenNewList = jdbcTemplate.query(
                "SELECT a.id, a.nombre, l.id, l.isbn,l.ano FROM ALMACEN_NEW a, LIBRO l WHERE a.id = l.almacen_new AND l.id = ?",
                new AlmacenNewRowMapper(), libro.getId());
        return almacenNewList;

    }

}
