package com.example.expense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
	info = @Info(
		title="Expense Tracker REST API Documentation",
		description = "Expense Tracker REST API Documentation",
		version = "v1.0",
		contact = @Contact(
			name = "Priyatham",
			email = "killua@gmail.com",
			url = "/"
		),
		license = @License(
			name = "Apache 2.0",
			url = "/license"
		)
	),
	externalDocs = @ExternalDocumentation(
		description = "Expense Tracker for REST API Documentation for Developers",
		url = "/external-docs"
	)
)
@SpringBootApplication
public class ExpenseTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerAppApplication.class, args);
	}

}
