package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.cars.BMW;
import com.example.cars.Merc;

@Configuration
@ComponentScan("com.example")
public class AppConfig {
	@Bean("myBMW")
	public BMW bmw() {
		return new BMW();
	}
	@Bean("myMerc")
	public Merc merc() {
		return new Merc();
	}

	
	
	

}
