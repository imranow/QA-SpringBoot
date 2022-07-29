package com.example.rest.dto;

import javax.persistence.EntityNotFoundException;

import com.example.persistence.domain.Band;
import com.example.persistence.domain.Musician;

public class MusicianDTO {
	private Long id;
	private String name;
	private Integer strings;
	private String type;
	private Band band;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStrings() {
		return strings;
	}
	public void setStrings(Integer strings) {
		this.strings = strings;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Band getBand() {
		return band;
	}
	public void setBand(Band band) {
		this.band = band;
	}
	
	
	

}
