package com.company.cabdataapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * @author Jon Bonso
 *
 * Main Class for the Cab Data API Service with Caching
 *
 */
@SpringBootApplication
@EnableCaching
public class CabDataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabDataApiApplication.class, args);
	}
}
