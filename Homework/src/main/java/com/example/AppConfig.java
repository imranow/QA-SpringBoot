package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.laptops.Dell;
import com.example.laptops.Sony;

@Configuration
//@ComponentScan("com.example")
public class AppConfig {
		@Bean("myDell")
		public Dell dell() {
			return new Dell();
		}
		@Bean("mySony")
		public Sony sony() {
			return new Sony();
		}

	}

