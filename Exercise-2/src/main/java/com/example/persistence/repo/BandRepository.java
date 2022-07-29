package com.example.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import com.example.persistence.domain.Band;

@Repository
@EnableJpaRepositories
public interface BandRepository extends JpaRepository<Band, Long>{
	@Query(value="select * from band where band id=?1", nativeQuery=true)
	List<Band>findBandById(Long id);
	
	@Query("SELECT b from Band b WHERE b.name = ?1")
    List<Band> findBandByName(String name);
	
	
	
	

}
