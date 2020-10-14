package com.poddubchak.education.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class HelloDockerApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(HelloDockerApplication.class, args);
		String greeting = Files.readString(Paths.get("src/main/resources/greeting.txt"));
		System.out.println(greeting);
	}

}
