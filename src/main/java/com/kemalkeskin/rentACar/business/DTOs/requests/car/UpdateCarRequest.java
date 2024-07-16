package com.kemalkeskin.rentACar.business.DTOs.requests.car;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class UpdateCarRequest {
	
	private int id;

	@Min(value =2015,message = "The model year can be at least 2015")
	private int modelYear;
	
	
	private String plate;	
	
	@Min(value = 700,message = "The minimum wage is 700 TL")
	private double dailyPrice;
	
	@Min(value =1,message = "Choose between 1 and 2")
	@Max(value = 2,message = "Choose between 1 and 2")
	private int status; 
	

	private int modelId;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getModelYear() {
		return modelYear;
	}


	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}


	public String getPlate() {
		return plate.toUpperCase();
	}


	public void setPlate(String plate) {
		this.plate = plate;
	}


	public double getDailyPrice() {
		return dailyPrice;
	}


	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getModelId() {
		return modelId;
	}


	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

}
