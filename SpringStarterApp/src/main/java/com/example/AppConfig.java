package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
	@Bean
	public String greeting() {
		return "Hello, World!";
	}
	@Bean
	@Scope("prototype")
	public Book getBook() {
		return new Book();
	}
	@Bean
	@Scope("prototype")
	public Flower getFlower() {
		return new Flower ();
	}
	@Bean
	@Scope("prototype")
	public Profile getProfile() {
		return new Profile ();
	}
	

}
