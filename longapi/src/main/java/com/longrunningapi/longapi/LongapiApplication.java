package com.longrunningapi.longapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class LongapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LongapiApplication.class, args);
	}

}
