package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrousGoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrousGoApplication.class, args);
		//dire bonjour
		System.out.println("Bonjour");
	}

}
