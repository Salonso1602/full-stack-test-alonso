package com.api.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@RestController
public class SwaggerRedirectController {

	@GetMapping("/")
	public RedirectView index() {
		return new RedirectView("/swagger-ui/index.html");
	}
	
}