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
	@Size(min = 3,message = "Brand name must be at least 3 characters long")
	private String name;
	
	@NotNull
	@NotBlank
	private int BrandId;
	
	@NotNull
	@NotBlank
	private int FuelId;
	
	@NotNull
	@NotBlank
	private int TransmissionId;

	
	
	public String getName() {
		return name.toUpperCase();
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBrandId() {
		return BrandId;
	}

	public void setBrandId(int brandId) {
		BrandId = brandId;
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
	
	
}
