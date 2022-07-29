package com.example.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.persistence.domain.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

}
