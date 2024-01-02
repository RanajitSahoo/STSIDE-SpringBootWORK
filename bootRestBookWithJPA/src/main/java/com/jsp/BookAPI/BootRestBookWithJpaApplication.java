package com.jsp.BookAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@SpringBootApplication(scanBasePackages = "com.jsp.BookAPI")
@EnableJpaRepositories(basePackages = "com.jsp.BookAPI.Repository")
public class BootRestBookWithJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRestBookWithJpaApplication.class, args);
	}

}
