package com.kemalkeskin.rentACar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "model_year")
	private int modelYear;
	
	@Column(name = "plate")
	private String plate;	
	
	@Column(name = "daily_price")
	private double dailyPrice;
	
	@Column(name = "status")
	private int status; // 1- rent  2-Available 
	
	@Column(name = "status_description")
	private String statusDescription;
	
	
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "model_id")
	private Model model;
	
	public Car() {
		
	}

	public Car(int modelYear, String plate, double dailyPrice, int status, Model model,String statusDescription) {
		super();
		this.modelYear = modelYear;
		this.plate = plate;
		this.dailyPrice = dailyPrice;
		this.status = status;
		this.model = model;
		this.statusDescription=statusDescription;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public String getPlate() {
		return plate;
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

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getStatusDescription() {
		
		if(getStatus()==1) {
			 statusDescription="rented";
		}else {
			statusDescription="Available";
		}
		
		
		return statusDescription;
	}


	
	
	
	
	

}
