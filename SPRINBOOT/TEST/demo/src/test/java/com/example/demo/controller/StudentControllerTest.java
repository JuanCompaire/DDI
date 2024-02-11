package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    StudentController controller;
    @Mock
    private StudentService service;

    @Test
    void testInsertarEstudiante() {
        Model model = new ExtendedModelMap();
        Student student = new Student();
        List<Student> listaPrecreada = createMockedList();
        when(service.insertStudent(student)).thenReturn(createMockedList());//listaPrecreada, puedes poner eso en vez de createMockedList, se pone para simplicar el codigo

        String finPage = controller.insertarEstudiante(student,model);
        assertEquals("fin", finPage);

        assertNotNull(model.getAttribute("estudiantes"));
        assertInstanceOf(List.class, model.getAttribute("estudiantes"));

        List<Student> lista = (List<Student>) model.getAttribute("estudiantes");
        assertFalse(lista.isEmpty());
        System.out.println(model.getAttribute("estudiantes"));

    }

    private static List<Student> createMockedList() {
        List<Student> listaPrecreada = new ArrayList<>();
        listaPrecreada.add(new Student(1,"Ignacio","Bielsa"));
        listaPrecreada.add(new Student(2,"Gorka","Larrubia"));
        return listaPrecreada;
    }


    @Test
    void testActualizarEstudiante(){

        Model model = new ExtendedModelMap();
        Student student = createMockedStudent();
        when(service.updateStudentList(student.getId())).thenReturn(createMockedStudent());

        String Finpage = controller.actualizarEstudiante(student.getId(), model);
        assertEquals("index", Finpage);

        assertNotNull(model.getAttribute("student"));
        assertInstanceOf(Student.class, model.getAttribute("student"));

        Student stud = (Student) model.getAttribute("student");
        assertNotNull(stud);
        System.out.println(model.getAttribute("student"));

    }

    private static Student createMockedStudent() {
        Student student = new Student();
        student.setId(1);
        student.setNombre("Ignacio");
        student.setApellido("Maradona");
        return student;

    }


    @Test
    void testBorrarEstudiante(){
        Model model = new ExtendedModelMap();
        List<Student> listaStudentList = new ArrayList<>();
        listaStudentList.add(new Student(1,"JUan","Putero"));
        listaStudentList.add(new Student(2,"Isabel","Pantoja"));
        
        String finPage = controller.borrarEstudiante(studtest.getId(), model);
        assertEquals("fin", finPage);
    }


    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        controller = new StudentController();
        controller.setService(service);
    }

    @AfterEach
    void tearDown() throws Exception {
    }


}
