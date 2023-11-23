package com.example.demo.repository;

import com.example.demo.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibroRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(Libro libro){
        jdbcTemplate.update("insert into LIBROS(titulo,autor) values (?, ?);",
                libro.getTitulo(), libro.getAutor());
    }

    public void update(Libro libro){
        jdbcTemplate.update("UPDATE LIBROS SET titulo = ?, autor = ? WHERE id =?",
                libro.getTitulo(), libro.getAutor(),libro.getId());
    }

    public void delete(Integer id){
        jdbcTemplate.update("DELETE FROM LIBROS WHERE id=?", new Object[]{id});
    }

    public List<Libro> findAll(){
        return jdbcTemplate.query("SELECT * FROM LIBROS", new LibrosRowMapper());
    }
}
