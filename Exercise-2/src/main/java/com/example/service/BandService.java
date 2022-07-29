package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.exception.BandNotFoundException;
import com.example.persistence.domain.Band;
import com.example.persistence.repo.BandRepository;

public class BandService {
	private BandRepository repo;

	public BandService(BandRepository repo) {
		super();
		this.repo = repo;
	}
	public Band addBand(Band bnd){
		return this.repo.save(bnd);
	}
	public List<Band> readBand() {
		return this.repo.findAll();
	
	}
	public Band updateBand(Long id, Band bnd){
		Band temp = this.repo.findById(id).orElseThrow(BandNotFoundException::new);
		Optional<Band> myTempBand=Optional.of(temp);
		Band existing=myTempBand.get();		
		existing.setId(bnd.getId());
		existing.setName(bnd.getName());
		return this.repo.save(existing);
	}
	public boolean deleteBand(Long id) {
		this.repo.deleteById(id);
		boolean exists=this.repo.existsById(id);
		return !exists;
	}
	
	public List<Band> getBandById(Long id){
		return this.repo.findBandById(id);
	}
	public List<Band> getBandByName(String name){
		return this.repo.findBandByName(name);
	}
	

}
