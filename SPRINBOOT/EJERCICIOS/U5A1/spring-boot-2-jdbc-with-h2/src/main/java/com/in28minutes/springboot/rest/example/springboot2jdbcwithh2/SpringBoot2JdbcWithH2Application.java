package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2;

import com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.student.Student;
import com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.student.StudentJdbcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot2JdbcWithH2Application implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentJdbcRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Student id 10001 -> {}", repository.findByid(10001L));

		logger.info("Student passport_number e1234567-> {}", repository.findBypassport_number("e1234567"));


		logger.info("inserting -> {}", repository.insert(new Student(10010L, "john", "a1234657")));

		logger.info("inserting -> {}", repository.insert(new Student(10020L, "marcos", "b1234657")));


		logger.info("update 10001 -> {}", repository.update(new Student(10001L, "name-updated", "new-passport")));

		repository.deleteByid(10002L);

		repository.deletedBypassport_number("b1234657");

		logger.info("all users 2 -> {}", repository.findAll());


	}
}
