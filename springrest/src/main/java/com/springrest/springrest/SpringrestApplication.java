package com.springrest.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication is combination of three annotations namely:
1. @SpringBootConfiguration
2. @EnableAutoConfiguration
3. @ComponentScan
 */
@SpringBootApplication
public class SpringrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrestApplication.class, args);
		System.out.println("Hello");
	}

}
