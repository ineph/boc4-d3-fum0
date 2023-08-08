package com.example.bocadefumoapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BocaDeFumoApiApplication {
	private static final Logger Logger = LoggerFactory.getLogger(BocaDeFumoApiApplication.class);

	public static void main(String[] args) {
		System.out.println(System.getenv("PSQL_PASS"));

		SpringApplication.run(BocaDeFumoApiApplication.class, args);

		Logger.debug("debug mensagem");
		Logger.info("info mensagem");
		Logger.warn("warn mensagem");
		Logger.error("error mensagem");
	}
}
