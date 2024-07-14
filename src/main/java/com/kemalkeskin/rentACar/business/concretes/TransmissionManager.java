package com.kemalkeskin.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.business.DTOs.responses.transmission.GetAllTransmissionResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.transmission.GetByIdTransmissionResponse;
import com.kemalkeskin.rentACar.business.abstracts.TransmissionService;
import com.kemalkeskin.rentACar.core.mapper.ModelMapperService;
import com.kemalkeskin.rentACar.dataAccess.abstracts.TransmissionRepository;
import com.kemalkeskin.rentACar.entities.concretes.Transmission;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class TransmissionManager implements TransmissionService{

	private TransmissionRepository transmissionRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllTransmissionResponse> getAll() {
		List<Transmission>transmissions=transmissionRepository.findAll();
		List<GetAllTransmissionResponse>getAllTransmissionResponses=transmissions.stream().map(transmission->modelMapperService.forResponse().map(transmission, GetAllTransmissionResponse.class)).collect(Collectors.toList());
		return getAllTransmissionResponses;
	}

	@Override
	public GetByIdTransmissionResponse getById(int id) {
		Optional<Transmission> transmission=transmissionRepository.findById(id);
		 if(!transmission.isPresent()) {
	
			 new RuntimeException("hata verdik");
		 }
		 GetByIdTransmissionResponse getByIdTransmissionResponse=this.modelMapperService.forResponse().map(transmission, GetByIdTransmissionResponse.class);
		 return getByIdTransmissionResponse;
	}
	
	
}
