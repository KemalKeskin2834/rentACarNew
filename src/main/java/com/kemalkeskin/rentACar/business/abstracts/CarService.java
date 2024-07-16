package com.kemalkeskin.rentACar.business.abstracts;

import java.util.List;

import com.kemalkeskin.rentACar.business.DTOs.requests.car.CreateCarRequest;
import com.kemalkeskin.rentACar.business.DTOs.requests.car.UpdateCarRequest;
import com.kemalkeskin.rentACar.business.DTOs.responses.car.GetAllCarResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.car.GetByIdCarResponse;

public interface CarService {
	
	List<GetAllCarResponse>getAll();
	
	GetByIdCarResponse getById(int id);
	
	void add(CreateCarRequest createCarRequest);
	
	void update(UpdateCarRequest updateCarRequest);
	
	void delete(int id);

}
