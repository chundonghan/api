package com.es.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.es.*")
@EnableTransactionManagement
public class ApiSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSpringBootApplication.class, args);
	}
}
