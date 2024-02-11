package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import com.example.demo.model.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;


class HelloControllerTest {

    HelloController controller;

    @Test
    void testHello() {
        //given
        Model model = new ExtendedModelMap();
        //when
        model.addAttribute("mensaje", "hola desde thymeleaf").toString();
        //then
        assertEquals("hola desde thymeleaf", model.getAttribute("mensaje"));
    }

    @Test
    void testIndex(){

        Model model = new ExtendedModelMap();

        String redirect = controller.index(model);

        assertEquals("index", redirect);

        assertNotNull(model);
        assertNotNull(model.getAttribute("student"));

        assertTrue(model.getAttribute("student") instanceof Student);
        assertInstanceOf(Student.class, model.getAttribute("student"));
    }

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        controller = new HelloController();
    }

    @AfterEach
    void tearDown() throws Exception {
    }
}