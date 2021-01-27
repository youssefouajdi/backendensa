package com.ensate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ensate")
public class CoursEnsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursEnsaApplication.class, args);
	}

}
