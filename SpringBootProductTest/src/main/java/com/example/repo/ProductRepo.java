package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product,Integer> {

	/*@Query(value="select * from product where brand=?1", nativeQuery=true)
	List<Product>findProductByBrand(String brand);
	
	//@Query("SELECT p from Person p WHERE p.name = ?1")
    List<Product> findProductByName(String name);*/
}
