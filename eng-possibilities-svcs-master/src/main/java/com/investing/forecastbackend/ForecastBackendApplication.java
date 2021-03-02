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
		return "Hello World!";
	}
	

	public static void main(String[] args) {
		SpringApplication.run(ForecastBackendApplication.class, args);
		System.out.println("whyyy");
		

		final String path = "C:\\Users\\brian\\OneDrive\\Documents\\Goldman Sachs Engineering Summit\\GSforecaster\\eng-possibilities-svcs-master\\src\\main\\resources\\data\\investment-details.json";
		
		
		try (FileReader reader = new FileReader(path)){
			JSONParser jsonP = new JSONParser();
			
			JSONObject obj =  (JSONObject) jsonP.parse(reader);//new JSONObject(new FileReader(path));
			//JSONArray array =  obj.getJSONArray("Investments");
			JSONArray arr = (JSONArray) obj.get("Investments");
			 System.out.println(arr);
			 JSONObject o1 = (JSONObject) arr.get(0);
			 System.out.println(o1.get("category"));
			 

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
