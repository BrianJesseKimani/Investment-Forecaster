package com.investing.forecastbackend.service;

import com.investing.forecastbackend.model.ForecastRequest;
import com.investing.forecastbackend.model.ForecastResponse;
import com.investing.forecastbackend.model.InvestmentDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class InvestingForecastService {

    public List<InvestmentDetail> getInvestmentOptions() {
        // TODO read investment options from investment-details.json
    	final String path = "C:\\Users\\brian\\OneDrive\\Documents\\Goldman Sachs Engineering Summit\\GSforecaster\\eng-possibilities-svcs-master\\src\\main\\resources\\data\\investment-details.json";
		
    	JSONArray jsonArray = null;
		try (FileReader reader = new FileReader(path)){
			JSONParser jsonP = new JSONParser();
			JSONObject parsedObject =  (JSONObject) jsonP.parse(reader);
			jsonArray = (JSONArray) parsedObject.get("Investments");
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Encountered File not found Exception");
			e.printStackTrace();
		} catch (IOException e) {
			
			System.out.println("Encountered IOException");
			e.printStackTrace();
		} catch (ParseException e) {
			
			System.out.println("Encountered ParseException");
			e.printStackTrace();
		}
		
		List<InvestmentDetail> investmentOptions = InvestmentDetail.fromJSONArray(jsonArray);
    	
    	
        return investmentOptions;
    }

    public ForecastResponse getInvestmentOptions(final ForecastRequest request) {
    	
        // TODO write algorithm to calculate investment forecast from request configuration
    	//how to calculate given historical data?
    	// forecast request has map<AssetClass, %investment> that we should take in and calculate returns with
    	//call get investment options here to get reference to historical data
    	//use testcases class to work backwords
    	
    	
        return new ForecastResponse();
    }

}
