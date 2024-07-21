	package com.kemalkeskin.rentACar.business.DTOs.requests.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class CreateModelRequest {

	@NotNull
	@NotBlank
	@Size(min = 1,message = "Brand name must be at least 1 characters long")
	private String name;
	
	@NotNull
	private int BrandId;
			
	
	@NotNull
	private int FuelId;
	
	@NotNull
	private int TransmissionId;

	
	
	public String getName() {
		return name.toUpperCase();
	}

	public void setName(String name) {
		this.name = name;
	}



	public int getFuelId() {
		return FuelId;
	}

	public void setFuelId(int fuelId) {
		FuelId = fuelId;
	}

	public int getTransmissionId() {
		return TransmissionId;
	}

	public void setTransmissionId(int transmissionId) {
		TransmissionId = transmissionId;
	}

	public int getBrandId() {
		return BrandId;
	}

	public void setBrandId(int brandId) {
		BrandId = brandId;
	}






	
	
}
