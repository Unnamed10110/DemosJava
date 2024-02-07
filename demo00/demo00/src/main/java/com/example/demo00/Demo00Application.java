package com.example.demo00;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// specifying the packages to be scanned
@SpringBootApplication(
		scanBasePackages = {
				"com.example.demo00",
				"demo.test.util"
		})
public class Demo00Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo00Application.class, args);
	}

}
