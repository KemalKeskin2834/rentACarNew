package com.kemalkeskin.rentACar.business.DTOs.responses.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetByIdModelResponse {

	private String name;
	
	
	private String BrandName;
	

	private String FuelName;
	

	private String TransmissionName;
}
