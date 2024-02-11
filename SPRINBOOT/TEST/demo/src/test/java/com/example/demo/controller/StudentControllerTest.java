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
    void testActualizarEstudiante() {
        // Arrange
        Model model = new ExtendedModelMap();
        int studentId = 1;
        Student updatedStudent = new Student(studentId, "UpdatedName", "UpdatedLastName");
        when(service.updateStudentList(studentId)).thenReturn(updatedStudent);

        // Act
        String redirection = controller.actualizarEstudiante(studentId, model);

        // Assert
        assertEquals("index", redirection);
        assertNotNull(model);
        assertNotNull(model.getAttribute("student"));
        assertTrue(model.getAttribute("student") instanceof Student);

        Student retrievedStudent = (Student) model.getAttribute("student");
        assertEquals(updatedStudent.getId(), retrievedStudent.getId());
        assertEquals(updatedStudent.getNombre(), retrievedStudent.getNombre());
        assertEquals(updatedStudent.getApellido(), retrievedStudent.getApellido());
    }


    @Test
    void testBorrarEstudiante(){
        Model model = new ExtendedModelMap();
        List<Student> listaBorrarStudent = createMockedStudentList();
        System.out.println(listaBorrarStudent);

        when(service.deleteStudent(2)).thenReturn(removeStudentFromList(listaBorrarStudent, 2));
        System.out.println(listaBorrarStudent.size());

        String finPage = controller.borrarEstudiante(2, model);
        assertEquals("fin", finPage);

        assertNotNull("estudiantes");
        assertInstanceOf(List.class, model.getAttribute("estudiantes"));

        List<Student> lista = (List<Student>) model.getAttribute("estudiantes");
        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        System.out.println(model.getAttribute("estudiantes"));
    }

    private static List<Student> createMockedStudentList() {
        List<Student> listaStudentList = new ArrayList<>();
        listaStudentList.add(new Student(1,"JUan","Putero"));
        listaStudentList.add(new Student(2,"Isabel","Pantoja"));
        return listaStudentList;
    }

    private List<Student> removeStudentFromList(List<Student> studentList, int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                studentList.remove(student);
                break;
            }
        }
        return studentList;
    }

    @Test
    void testBuscarEstudiantes(){
        Model model = new ExtendedModelMap();
        List<Student> listaPreBusqueda = studentSearchList();
        when(service.searchStudent("Juan")).thenReturn(searchStudent(listaPreBusqueda));

        String finPage = controller.buscarEstudiantes("Juan", model);
        assertEquals("fin", finPage);

        assertNotNull(model.getAttribute("estudiantes"));
        assertInstanceOf(List.class, model.getAttribute("estudiantes"));

        List <Student> lista = (List<Student>) model.getAttribute("estudiantes");
        assertNotNull(lista);
        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        System.out.println(model.getAttribute("estudiantes"));

    }

    private List<Student> searchStudent(List<Student> lista){
        List<Student> listaBuscarStudent = new ArrayList<>();
        for (Student student : lista) {
            if (student.getNombre().equals("Juan")) {
                listaBuscarStudent.add(student);
            }

        }
        return listaBuscarStudent;

    }

    private static List<Student> studentSearchList() {
        List<Student> listaBuscarStudent = new ArrayList<>();
        listaBuscarStudent.add(new Student(1,"Juan","Perez"));
        listaBuscarStudent.add(new Student(2,"Isabel","Pantoja"));
        return listaBuscarStudent;
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
