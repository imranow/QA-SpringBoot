package com.example.rest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.model.Product;
import com.example.repo.ProductRepo;
import com.example.service.ProductService;


@SpringBootTest
public class ProductServiceUnitTest {
	@Autowired
	private ProductService service;
	
	@MockBean
	private ProductRepo repo;
	
	@Test
    void testCreate() {
    	 // GIVEN is our testing data - you can make this a final local variable if you want, e.g.:
        final Product TEST_PRODUCT = new Product(101, "MacBook", "Apple");
        final Product TEST_SAVED_PRODUCT = new Product(102,"MacBook", "Apple");

        // WHEN
        Mockito.when(this.repo.save(TEST_PRODUCT)).thenReturn(TEST_SAVED_PRODUCT);

        // THEN
        Assertions.assertThat(this.service.create(TEST_PRODUCT)).isEqualTo(TEST_SAVED_PRODUCT);

        // verify that our repo was accessed exactly once
        Mockito.verify(this.repo, Mockito.times(1)).save(TEST_PRODUCT);
    }


}
