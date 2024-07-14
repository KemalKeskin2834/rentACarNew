package com.kemalkeskin.rentACar.business.abstracts;

import java.util.List;

import com.kemalkeskin.rentACar.business.DTOs.responses.model.GetAllModelResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.model.GetByIdModelResponse;

public interface ModelService {

	List<GetAllModelResponse>getAll();
	
	GetByIdModelResponse getById(int id);
}
