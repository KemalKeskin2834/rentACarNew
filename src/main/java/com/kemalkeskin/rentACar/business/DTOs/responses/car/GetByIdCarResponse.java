package com.kemalkeskin.rentACar.business.DTOs.responses.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetByIdCarResponse {
	
	private int id;

	private int modelYear;
	
	
	private String plate;	
	

	private double dailyPrice;
	

	private String statusDescription; 
	 
	

	private String modelName;
}
