package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyFirstSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(MyFirstSpringBootApplication.class, args);
		Object byName=context.getBean("Greeting");
		String byType=context.getBean(String.class);
		String byBoth=context.getBean("greeting", String.class);
		System.out.println(byName);
		System.out.println(byType);
	}

}
