package com.example.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import com.example.persistence.domain.Musician;
@Repository
@EnableJpaRepositories
public interface MusicianRepository extends JpaRepository<Musician, Long>{
	@Query(value="select * from Musician where musician id=?1", nativeQuery=true)
	List<Musician>findMusicianById(Long id);
	
	@Query("SELECT m from Musician m WHERE m.name = ?1")
    List<Musician> findMusicianByName(String name);

}
