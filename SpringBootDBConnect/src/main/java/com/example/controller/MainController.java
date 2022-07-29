package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;





@RestController
public class MainController {
	private ProductService service;
	
	public MainController(ProductService service) {
		super();
		this.service = service;
	}
	//list.add(p1);
	@PostMapping("/create")
	public Product create(@RequestBody Product prod){ 
	
		return this.service.addProduct(prod);
	}
	@GetMapping("/products")
	public List<Product> getList() {
		return this.service.readProduct();
	
	}
	@PutMapping("/update/{id}")
	public Product update (@PathVariable int id,@RequestBody Product prod) {
	
		return this.service.updateProduct(id, prod);
	}
	@DeleteMapping("/delete/{id}")
	public void delete (@PathVariable int id) {
		this.service.deleteProduct(id);
	}
	/*@GetMapping("/read/{brand}")
	public List<Product> read(@PathVariable String brand){
		return this.service.getProductByBrand(brand);
	}
	@GetMapping("/read/{name}")
	public List<Product> readName(@PathVariable String name){
		return this.service.getProductByName(name);
	}*/
	@GetMapping("/home")
	public String home() {
		return "My home";
	}

}


