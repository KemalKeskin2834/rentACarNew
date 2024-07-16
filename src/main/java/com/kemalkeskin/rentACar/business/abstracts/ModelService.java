package com.kemalkeskin.rentACar.business.abstracts;

import java.util.List;

import com.kemalkeskin.rentACar.business.DTOs.requests.model.CreateModelRequest;
import com.kemalkeskin.rentACar.business.DTOs.requests.model.UpdateModelRequest;
import com.kemalkeskin.rentACar.business.DTOs.responses.model.GetAllModelResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.model.GetByIdModelResponse;

public interface ModelService {

	List<GetAllModelResponse>getAll();
	
	GetByIdModelResponse getById(int id);
	
	void add(CreateModelRequest createModelRequest);
	
	void update(UpdateModelRequest updateModelRequest,int id);
	
	void delete(int id);
}
