package com.investing.forecastbackend;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class ForecastBackendApplication {
	
	@RequestMapping("/")
	String home() {
		return "WELCOME TO DEEP POCKETS BACK-END!";
	}
	

	public static void main(String[] args) {
		SpringApplication.run(ForecastBackendApplication.class, args);
		System.out.println("PROJECT IS RUNNING");
	
	}

}
