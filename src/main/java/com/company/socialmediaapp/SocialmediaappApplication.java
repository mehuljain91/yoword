package com.company.socialmediaapp;

import com.company.socialmediaapp.config.OpenAPIConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(OpenAPIConfiguration.class)
public class SocialmediaappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialmediaappApplication.class, args);
	}

}
