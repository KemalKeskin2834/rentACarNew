package com.kemalkeskin.rentACar.business.abstracts;

import java.util.List;

import com.kemalkeskin.rentACar.business.DTOs.responses.transmission.GetAllTransmissionResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.transmission.GetByIdTransmissionResponse;

public interface TransmissionService {

	List<GetAllTransmissionResponse>getAll();
	
	GetByIdTransmissionResponse getById(int id);
}
