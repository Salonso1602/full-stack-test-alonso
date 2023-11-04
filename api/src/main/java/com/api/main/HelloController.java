package com.api.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class HelloController {

	@Operation(summary = "/", description = "Hola Mundo")
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
}