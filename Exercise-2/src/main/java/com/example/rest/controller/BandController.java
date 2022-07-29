package com.example.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.persistence.domain.Band;
import com.example.service.BandService;

public class BandController {
	private BandService service;

	public BandController(BandService service) {
		super();
		this.service = service;
	}
	@PostMapping("/create")
	public Band create(@RequestBody Band bnd){ 
	
		return this.service.addBand(bnd);
	}
	@GetMapping("/band")
	public List<Band> getList() {
		return this.service.readBand();
	
	}
	@PutMapping("/update/{id}")
	public Band update (@PathVariable Long id,@RequestBody Band bnd) {
	
		return this.service.updateBand(id, bnd);
	}
	@DeleteMapping("/delete/{id}")
	public void delete (@PathVariable Long id) {
		this.service.deleteBand(id);
	}
	@GetMapping("/read/{bandid}")
	public List<Band> read(@PathVariable Long id){
		return this.service.getBandById(id);
	}
	@GetMapping("/read/{name}")
	public List<Band> readName(@PathVariable String name){
		return this.service.getBandByName(name);
	}
	@GetMapping("/home")
	public String home() {
		return "My home";
	}

	

	
}
