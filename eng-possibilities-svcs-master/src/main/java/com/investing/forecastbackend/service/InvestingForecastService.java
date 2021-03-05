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
import java.util.Map;

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
    	//Use Discrete probability distributution of historical data to estimate expected return 
    	// forecast request has map<AssetClass, %investment> that we should take in and calculate returns with
    	
    	
    	Map<String,Double> userRequest = request.populateRequestMap();
    	//call get investment options here to get reference to historical data
    	List<InvestmentDetail> historicalData = getInvestmentOptions();
    	
    	//Assert that minimum investment has been met.
    	for(int i = 0; i < historicalData.size(); i++) {
    		String category = historicalData.get(i).getCategory();
    		double minimum = (double) historicalData.get(i).getMinimum();
    		if(userRequest.get(category)<minimum) {
    			System.out.println(category + "Investment is below minimum required cash injection for Asset Class");
    			return null;
    		}
    	}
    	
    	//calculate rate of return 
    	double returnRate = calculateRate(historicalData,userRequest);
    	List<Double> annualReturns = new ArrayList<Double>(); // list of returns per year
    	//calculate 10-year forecast
    	int forecastPeriod = 10;
    	double principle = 10000.0; 
    	double compoundValue = 1 + returnRate;
    	for(int i = 0; i < forecastPeriod; i++) {
    		double yearlyReturn = principle*(Math.pow(compoundValue, 1));
    		annualReturns.add(yearlyReturn);
    		principle = yearlyReturn;
    	}
    	
    	ForecastResponse response = new ForecastResponse();
    	response.setResponse(annualReturns);
    	
        return response;
    }
    // returns the portfolio expected rate of return 
	public double calculateRate(List<InvestmentDetail> historicalData, Map<String, Double> userRequest) {
		List<Double> categoryEstimateReturn = new ArrayList<>(); //list of returns per category
		double answerRate = 0;
		for(InvestmentDetail data: historicalData) {
			double rateEstimate = ExpectedValueFromDistribution(data.getData());
			categoryEstimateReturn.add(rateEstimate);
		}
		for(int i = 0; i < historicalData.size() && i < categoryEstimateReturn.size(); i++) {
			String category = historicalData.get(i).getCategory();
			answerRate += categoryEstimateReturn.get(i)*(userRequest.get(category)/100);
		}
		
		return answerRate;
	}
	//returns the expected rate of return for an asset category using historical data
	public double ExpectedValueFromDistribution(String[] data) {
		
		double result = 0;
		double probability = 0.1; //assuming an equal probalility of 10%
		for(int i = 0; i < data.length; i++) {
			result+= probability*(Double.parseDouble(data[i])/100);
		}
		return result;
	}

}
