package com.kemalkeskin.rentACar.business.abstracts;

import java.util.List;

import com.kemalkeskin.rentACar.business.DTOs.requests.fuel.CreateFuelRequest;
import com.kemalkeskin.rentACar.business.DTOs.requests.fuel.UpdateFuelRequest;
import com.kemalkeskin.rentACar.business.DTOs.responses.fuel.GetAllFuelResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.fuel.GetByIdFuelResponse;

public interface FuelService {

	List<GetAllFuelResponse>getAll();
	
	GetByIdFuelResponse getById(int id);
	
	void add(CreateFuelRequest createFuelRequest);
	
	void update(UpdateFuelRequest updateFuelRequest,int id);
	
	void delete(int id);
}
