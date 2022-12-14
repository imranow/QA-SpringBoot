package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.person.Person;


@Repository
@EnableJpaRepositories
	public interface PersonRepo extends JpaRepository<Person, Long>{
		@Query(value="select * from person where person id=?1", nativeQuery=true)
		List<Person>findPersonById(Long id);
		
		@Query("SELECT p from Person a WHERE p.name = ?1")
	    List<Person> findPersonByName(String name);
		

	

}
