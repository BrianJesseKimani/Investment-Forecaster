package com.investing.forecastbackend.model;

import java.util.HashMap;

//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

import java.util.Map;

import org.json.simple.JSONObject;



//@Data
//@Getter
//@Setter
// TODO Use Lombok (commented above) for Getters and Setters, Optionally you can generate them.
public class ForecastRequest {
    private Map<String, Double> request;
    private double energy ;
    private double technology;
    private double financialservices;
    private double airline;
    private double retail;
    private double gaming;
    private double pharmaceuticals;
    private double realestate;
    
    public ForecastRequest() {}

	
	public ForecastRequest(Map<String, Double> request, double energy, double technology, double financialservices,
			double airline, double retail, double gaming, double pharmaceuticals, double realestate) {
		super();
		request = new HashMap<String, Double>();
		this.request = request;
		this.energy = energy;
		this.technology = technology;
		this.financialservices = financialservices;
		this.airline = airline;
		this.retail = retail;
		this.gaming = gaming;
		this.pharmaceuticals = pharmaceuticals;
		this.realestate = realestate;
	}

	public Map<String, Double> populateRequestMap(){
		request = new HashMap<String, Double>();
		request.put("Energy", energy);
		request.put("Technology", technology);
		request.put("Financial Services", financialservices);
		request.put("Airline", airline);
		request.put("Retail", retail);
		request.put("Gaming", gaming);
		request.put("Pharmaceuticals", pharmaceuticals);
		request.put("Real Estate", realestate);
		
		return request;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

	public double getTechnology() {
		return technology;
	}

	public void setTechnology(double technology) {
		this.technology = technology;
	}

	public double getFinancialservices() {
		return financialservices;
	}

	public void setFinancialservices(double financialservices) {
		this.financialservices = financialservices;
	}

	public double getAirline() {
		return airline;
	}

	public void setAirline(double airline) {
		this.airline = airline;
	}

	public double getRetail() {
		return retail;
	}

	public void setRetail(double retail) {
		this.retail = retail;
	}

	public double getGaming() {
		return gaming;
	}

	public void setGaming(double gaming) {
		this.gaming = gaming;
	}

	public double getPharmaceuticals() {
		return pharmaceuticals;
	}

	public void setPharmaceuticals(double pharmaceuticals) {
		this.pharmaceuticals = pharmaceuticals;
	}

	public double getRealestate() {
		return realestate;
	}

	public void setRealestate(double realestate) {
		this.realestate = realestate;
	}

	public Map<String, Double> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Double> request) {
		this.request = request;
	}
    
    
}
