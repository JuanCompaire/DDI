package com.example.biblioteca.repository;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.model.LibroRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LibroRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(Libro libro) {
        jdbcTemplate.update("insert into LIBRO(isbn,fechaEdicion,almacen_old,almacen_new) values(?,?,?,?);",
                libro.getIsbn(), libro.getFechaEdicion(), libro.getAlmacen_old(), libro.getAlmacen_new());

    }

    public void update(Libro libro) {
        jdbcTemplate.update("UPDATE LIBRO SET isbn = ?, fechaEdicion = ?, almacen_old = ?, almacen_new = ?",
                libro.getIsbn(), libro.getFechaEdicion(), libro.getAlmacen_old(), libro.getAlmacen_new());
    }

    public void delete(Integer id) {
        jdbcTemplate.update("DELETE FROM LIBRO WHERE id = ?", new Object[]{id});
    }

    public List<Libro> findAll() {
        return jdbcTemplate.query("SELECT * FROM LIBRO", new LibroRowMapper());
    }

    public Libro findById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM LIBRO WHERE id = ?",
                new BeanPropertyRowMapper<Libro>(Libro.class), new Object[]{id});
    }

    public List<Libro> findByIsbn(String isbn) {
        return jdbcTemplate.query("SELECT * FROM LIBRO WHERE isbn = ?",
                new LibroRowMapper(), isbn);

    }
}


