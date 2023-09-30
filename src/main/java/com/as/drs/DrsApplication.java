package com.as.drs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;
@SpringBootApplication
public class DrsApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load();

		// Get the values for DB_USERNAME and DB_PASSWORD
		String dbUsername = dotenv.get("DB_USERNAME");
		String dbPassword = dotenv.get("DB_PASSWORD");

		// Set the environment variables
		System.setProperty("DB_USERNAME", dbUsername);
		System.setProperty("DB_PASSWORD", dbPassword);
		SpringApplication.run(DrsApplication.class, args);
	}

}
