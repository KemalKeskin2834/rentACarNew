package com.kemalkeskin.rentACar.business.abstracts;

import java.util.List;

import com.kemalkeskin.rentACar.business.DTOs.requests.transmission.CreateTransmissionRequest;
import com.kemalkeskin.rentACar.business.DTOs.requests.transmission.UpdateTransmissionRequest;
import com.kemalkeskin.rentACar.business.DTOs.responses.transmission.GetAllTransmissionResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.transmission.GetByIdTransmissionResponse;

public interface TransmissionService {

	List<GetAllTransmissionResponse>getAll();
	
	GetByIdTransmissionResponse getById(int id);
	
	void add(CreateTransmissionRequest createTransmissionRequest);
	
	void update(UpdateTransmissionRequest updateTransmissionRequest,int id);
	
	void delete(int id);
}
