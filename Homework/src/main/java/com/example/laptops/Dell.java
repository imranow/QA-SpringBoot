package com.example.laptops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.example.interfaces.HardDisk;
import com.example.interfaces.Laptop;

public class Dell implements Laptop{
	@Autowired
	@Qualifier("HitachiStorage")
	HardDisk hdd;
	
	public void type() {
		return "This is a Dell laptop with HDD storage as "+hdd.storage();
	}
	
	

}
