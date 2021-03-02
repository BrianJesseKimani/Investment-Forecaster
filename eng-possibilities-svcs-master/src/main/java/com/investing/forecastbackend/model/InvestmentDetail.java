package com.investing.forecastbackend.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

// TODO Model the data read from ../resources/data/investment-details.json
public class InvestmentDetail {
	
	private String category;
	private int minimum;
	private String[] data;
	
	
	//Empty Constructor
	public InvestmentDetail() {}
	
	//Reading from provided JSON file
	//should we have another method to parse in user data??
	public InvestmentDetail(JSONObject jsonObj) {
		super();
		this.category = (String) jsonObj.get("category");
		String tempMin = (String) jsonObj.get("minimum");
		this.minimum = Integer.parseInt(tempMin) ;
		JSONArray tempJSONArray = (JSONArray) jsonObj.get("data");
		String[] dataArray = new String[tempJSONArray.size()];
		for(int i = 0; i < tempJSONArray.size(); i++) {
			dataArray[i] = (String) tempJSONArray.get(i);
		}
		this.data = dataArray;
	}
	
	public static List<InvestmentDetail> fromJSONArray(JSONArray array){
		List<InvestmentDetail> investmentDetails = new ArrayList<InvestmentDetail>();
		
		for(int i = 0; i < array.size(); i++) {
			JSONObject tempObject = (JSONObject) array.get(i);
			InvestmentDetail details = new InvestmentDetail(tempObject);
			investmentDetails.add(details);
		}
		
		return investmentDetails;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

	
	
	public static void parseg (String[] args) {
			
			final String path = "C:\\Users\\brian\\OneDrive\\Documents\\Goldman Sachs Engineering Summit\\GSforecaster\\eng-possibilities-svcs-master\\src\\main\\resources\\data\\investment-details.json";
			try {
				JSONParser jsonP = new JSONParser(new FileReader(path));
				ArrayList<Object> jsonArray = jsonP.parseArray();
				System.out.println(jsonArray);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
}
