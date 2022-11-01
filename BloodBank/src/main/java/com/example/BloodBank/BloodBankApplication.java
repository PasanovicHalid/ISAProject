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

import java.util.ArrayList;

@SpringBootApplication
public class BloodBankApplication {

	public static ArrayList<BloodBank> bloodBanks;
	public static void main(String[] args) {
		SpringApplication.run(BloodBankApplication.class, args);

//		BloodBank bloodBank1 = new BloodBank(2, 4, 0, 0, 5, 3, 2, 6, 1,
//				"New Life", "newlife@gmail.com", "bla bla", 4.4, new ArrayList<>());
//		BloodBank bloodBank2 = new BloodBank(1, 0, 0, 0, 0, 8, 7, 0, 2,
//				"Bloody Hell", "bloodyhell@gmail.com", "bla bla", 3.4, new ArrayList<>());
//		BloodBank bloodBank3 = new BloodBank(0, 0, 1, 3, 5, 5, 9, 3, 3,
//				"Bloody Mary", "bloodymary@gmail.com", "bla bla", 2.4, new ArrayList<>());
//
//		bloodBanks = new ArrayList<BloodBank>();
//		bloodBanks.add(bloodBank1);
//		bloodBanks.add(bloodBank2);
//		bloodBanks.add(bloodBank3);
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

}
