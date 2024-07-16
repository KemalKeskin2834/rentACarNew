package com.kemalkeskin.rentACar.business.DTOs.requests.brand;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class UpdateBrandRequest {
	
	@JsonIgnore
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 3,message = "Brand name must be at least 3 characters long")
	private String name;
	
	public String getName() {
		return name.toUpperCase();
	}

	public void setName(String name) {
		this.name = name;
	}
}
