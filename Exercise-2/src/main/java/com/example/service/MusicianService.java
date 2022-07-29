package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.exception.BandNotFoundException;
import com.example.exception.MusicianNotFoundException;
import com.example.persistence.domain.Band;
import com.example.persistence.domain.Musician;
import com.example.persistence.repo.MusicianRepository;

public class MusicianService {
	private MusicianRepository repo;

	public MusicianService(MusicianRepository repo) {
		super();
		this.repo = repo;
	}
	public Musician addMusician(Musician mscn){
		return this.repo.save(mscn);
	}
	public List<Musician> readMusician() {
		return this.repo.findAll();
	
	}
	public Musician updateMusician(Long id, Musician mscn){
		Musician temp = this.repo.findById(id).orElseThrow(MusicianNotFoundException::new);
		Optional<Musician> myTempMusician=Optional.of(temp);
		Musician existing=myTempMusician.get();		
		existing.setId(mscn.getId());
		existing.setName(mscn.getName());
		return this.repo.save(existing);
	}
	public boolean deleteMusician(Long id) {
		this.repo.deleteById(id);
		boolean exists=this.repo.existsById(id);
		return !exists;
	}
	public List<Musician> getMusicianById(Long id){
		return this.repo.findMusicianById(id);
		}
	public List<Musician> getMusicianByName(String name){
		return this.repo.findMusicianByName(name);
		
	}
	
}
	
	
	
	


