package com.kemalkeskin.rentACar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kemalkeskin.rentACar.core.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car  extends BaseEntity{
	
	@Column(name = "model_year")
	private int modelYear;
	
	@Column(name = "plate")
	private String plate;	
	
	@Column(name = "daily_price")
	private double dailyPrice;
	
	@Column(name = "status")
	private int status; // 1- rent  2-Available 
	
	
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "model_id")
	private Model model;

	public Car(int modelYear, String plate, double dailyPrice, int status, Model model) {
		super();
		this.modelYear = modelYear;
		this.plate = plate;
		this.dailyPrice = dailyPrice;
		this.status = status;
		this.model = model;
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


	
	
	
	
	

}
