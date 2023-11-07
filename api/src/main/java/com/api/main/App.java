package com.api.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.api.controllers")
@EntityScan(basePackages = "com.api.models")
public class App {


	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
