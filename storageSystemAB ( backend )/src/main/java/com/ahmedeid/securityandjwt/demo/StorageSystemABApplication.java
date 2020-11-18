package com.ahmedeid.securityandjwt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class StorageSystemABApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(StorageSystemABApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(StorageSystemABApplication.class, args);
	}

}
