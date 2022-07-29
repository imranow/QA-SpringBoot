package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.interfaces.Car;

@SpringBootApplication
public class DependencyInjection {

	public static void main(String[] args) {
		//ApplicationContext context = SpringApplication.run(DependencyInjection.class, args);
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		Car myCar=context.getBean("myBMW", Car.class);
		System.out.println(myCar.spec());
		
		Car myCar1=context.getBean("myMerc", Car.class);
		System.out.println(myCar1.spec());
		
		
		
	}

}
