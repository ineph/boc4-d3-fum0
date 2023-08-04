package com.example.bocadefumoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BocaDeFumoApiApplication {

	public static void main(String[] args) {
		System.out.println(System.getenv("PSQL_PASS"));
		SpringApplication.run(BocaDeFumoApiApplication.class, args);
	}

}
