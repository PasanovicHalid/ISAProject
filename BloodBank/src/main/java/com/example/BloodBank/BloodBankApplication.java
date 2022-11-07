package com.example.BloodBank;

import com.example.BloodBank.model.BloodBank;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;

@SpringBootApplication
public class BloodBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankApplication.class, args);

	}
	// da bismo slali headere sa fronta na back
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**").allowedOrigins("http://localhost:4200");
			}
		};
	}

	@Bean
	public Validator validator() {
		ValidatorFactory validatorFactory = Validation.byDefaultProvider().configure().buildValidatorFactory();
		return validatorFactory.getValidator();
	}

}
