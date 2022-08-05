package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.exception.ProductNotFoundException;
import com.example.model.Product;
import com.example.repo.ProductRepo;

@Service
public class ProductService {
	private ProductRepo repo;
	//public List <Product> list=new ArrayList();
	
	public ProductService(ProductRepo repo) {
		super();
		this.repo = repo;
	}
	
	public Product addProduct(Product prod){
		return this.repo.save(prod);
	}
	public List<Product> readProduct() {
		return this.repo.findAll();
	
	}
	public Product updateProduct(int id, Product prod){
		Product temp = this.repo.findById(id).orElseThrow(ProductNotFoundException::new);
		Optional<Product> myTempProduct=Optional.of(temp);
		Product existing=myTempProduct.get();		
		existing.setBrand(prod.getBrand());
		existing.setName(prod.getName());
		return this.repo.save(existing);
	}
	public boolean deleteProduct(int id) {
		this.repo.deleteById(id);
		boolean exists=this.repo.existsById(id);
		return !exists;
	}
	
	/*public List<Product> getProductByBrand(String brand){
		return this.repo.findProductByBrand(brand);
	}
	public List<Product> getProductByName(String name){
		return this.repo.findProductByName(name);
	}*/

}
