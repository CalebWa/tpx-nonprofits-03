package com.example.TPXProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TpxProjApplication {
	public static void main(String[] args) {
		SpringApplication.run(TpxProjApplication.class, args);
	}
}