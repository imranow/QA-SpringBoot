package com.example.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.persistence.domain.Musician;
import com.example.service.MusicianService;

public class MusicianController {
	private MusicianService service;

	public MusicianController(MusicianService service) {
		super();
		this.service = service;
	}
	@PostMapping("/create")
	public Musician create(@RequestBody Musician mscn){ 
	
		return this.service.addMusician(mscn);
	}
	@GetMapping("/musician")
	public List<Musician> getList() {
		return this.service.readMusician();
	}
	@PutMapping("/update/{id}")
	public Musician update (@PathVariable Long id,@RequestBody Musician mscn) {
		return this.service.updateMusician(id, mscn);
	}
	@DeleteMapping("/delete/{id}")
	public void delete (@PathVariable Long id) {
		this.service.deleteMusician(id);
	}
	@GetMapping("/read/{musicianid}")
	public List<Musician> read(@PathVariable Long id){
		return this.service.getMusicianById(id);
	}
	@GetMapping("/read/{name}")
	public List<Musician> readName(@PathVariable String name){
		return this.service.getMusicianByName(name);
	}
	@GetMapping("/home")
	public String home() {
		return "My home";
	}

	
	

}
