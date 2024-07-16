package com.kemalkeskin.rentACar.business.DTOs.responses.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllCarResponse {
	
	private int modelYear;
	
	
	private String plate;	
	

	private double dailyPrice;
	

	private int status; 
	

	private String modelName;
	
	

	

}
