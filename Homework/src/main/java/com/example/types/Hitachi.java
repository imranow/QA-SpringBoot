package com.example.types;

import org.springframework.stereotype.Component;

import com.example.interfaces.Laptop;

@Component("HitachiStorage")
public class Hitachi implements Laptop{
	public String type() {
		return "Hitachi which is designed by Imran";
	}

}
