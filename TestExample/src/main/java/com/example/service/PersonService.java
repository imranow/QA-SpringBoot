package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.persistence.domain.Person;
import com.example.persistence.exceptions.PersonNotFoundException;
import com.example.persistence.repo.PersonRepo;

@Service
public class PersonService {

	private PersonRepo repo;

	public PersonService(PersonRepo repo) {
		super();
		this.repo = repo;
	}

	public Person create(Person person) {
		return this.repo.save(person);
	}

	public Person readOne(Long id) {
		return this.repo.findById(id).orElseThrow(PersonNotFoundException::new);
	}

	public List<Person> readAll() {
		return this.repo.findAll();
	}

	public Person update(Person person, Long id) {
		Person toUpdate = this.readOne(id);
		toUpdate.setName(person.getName());
		toUpdate.setAge(person.getAge());
		return this.repo.save(toUpdate);
	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
