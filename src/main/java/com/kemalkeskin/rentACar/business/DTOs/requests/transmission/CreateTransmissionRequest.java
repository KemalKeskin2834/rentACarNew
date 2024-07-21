package com.kemalkeskin.rentACar.business.DTOs.requests.transmission;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class CreateTransmissionRequest {

	@NotNull
	
	@Size(min = 1,message = "Brand name must be at least 3 characters long")
	private String name;

	public String getName() {
		return name.toUpperCase();
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
