package com.example.demo.service;

import com.example.demo.controller.StudentController;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Spy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    StudentService service;

    @Spy
    StudentRepository repository;

    void testInsertStudent(){
        Student student = new Student();
        student.setNombre("Juan");
        student.setApellido("Perez");
        student.setId(null);

        List<Student> studentList = service.insertStudent(student);
        assertNotNull(studentList);
        assertFalse(studentList.isEmpty());



    }

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        service = new StudentService();
        service.setStudentRepo(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
    }
}
