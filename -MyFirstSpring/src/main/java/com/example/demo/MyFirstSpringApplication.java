package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyFirstSpringApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MyFirstSpringApplication.class, args);
		
		
		Object byName1 = context.getBean("greeting");
		System.out.println(byName1);
		Object byName2 = context.getBean("getBook");
		System.out.println(byName2);
		Object byName3 = context.getBean("getFlower");
		System.out.println(byName3);
		

	}
	
	
	

}
