package com.example.Falak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.example.Falak.repository")
@SpringBootApplication
public class FalakApplication {

	public static void main(String[] args) {
		SpringApplication.run(FalakApplication.class, args);
		System.out.println("You're Doing Great Nora :) Keep it up!!");


	}

}
