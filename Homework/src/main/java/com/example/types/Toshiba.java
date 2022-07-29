package com.example.types;

import org.springframework.stereotype.Component;

import com.example.interfaces.Laptop;

@Component("ToshibaStorage")
public class Toshiba implements Laptop{
	public String type() {
		return "Toshiba which is designed by Imran";
	}
	
	

}
