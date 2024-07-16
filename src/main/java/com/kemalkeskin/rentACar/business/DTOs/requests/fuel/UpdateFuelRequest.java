package com.kemalkeskin.rentACar.business.DTOs.requests.fuel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateFuelRequest {
	
	@NotNull
	@NotBlank
	@Size(min = 3,message = "Brand name must be at least 3 characters long")
	private String name;

}
