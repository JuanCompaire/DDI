package com.example.demo.repository;

import com.example.demo.dto.PersonDTO;
import org.springframework.stereotype.Service;

@Service
public class PersonRepositoryImpl implements PersonRepository {

	@Override
	public void persist(final PersonDTO personDTO) {
		// implementation of persisting to database
	}
}
