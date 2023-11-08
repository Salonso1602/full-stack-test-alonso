package com.api.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.api")
@EnableJpaRepositories(basePackages = "com.api.repository")
@EntityScan(basePackages = "com.api.repository.entities.entityImplementations")
public class App {


	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
