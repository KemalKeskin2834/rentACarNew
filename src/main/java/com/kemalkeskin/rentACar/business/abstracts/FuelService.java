package com.kemalkeskin.rentACar.business.abstracts;

import java.util.List;

import com.kemalkeskin.rentACar.business.DTOs.responses.fuel.GetAllFuelResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.fuel.GetByIdFuelResponse;

public interface FuelService {

	List<GetAllFuelResponse>getAll();
	
	GetByIdFuelResponse getById(int id);
}
