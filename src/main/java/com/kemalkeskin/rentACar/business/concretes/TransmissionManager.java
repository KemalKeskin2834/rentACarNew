package com.kemalkeskin.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.business.DTOs.requests.transmission.CreateTransmissionRequest;
import com.kemalkeskin.rentACar.business.DTOs.requests.transmission.UpdateTransmissionRequest;
import com.kemalkeskin.rentACar.business.DTOs.responses.transmission.GetAllTransmissionResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.transmission.GetByIdTransmissionResponse;
import com.kemalkeskin.rentACar.business.abstracts.TransmissionService;
import com.kemalkeskin.rentACar.business.rules.TransmissionBusinessRules;
import com.kemalkeskin.rentACar.core.mapper.ModelMapperService;
import com.kemalkeskin.rentACar.dataAccess.abstracts.TransmissionRepository;
import com.kemalkeskin.rentACar.entities.concretes.Transmission;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class TransmissionManager implements TransmissionService{

	private TransmissionRepository transmissionRepository;
	private ModelMapperService modelMapperService;
	private TransmissionBusinessRules transmissionBusinessRules;

	@Override
	public List<GetAllTransmissionResponse> getAll() {
		List<Transmission>transmissions=transmissionRepository.findAll();
		List<GetAllTransmissionResponse>getAllTransmissionResponses=transmissions.stream().map(transmission->modelMapperService.forResponse().map(transmission, GetAllTransmissionResponse.class)).collect(Collectors.toList());
		return getAllTransmissionResponses;
	}

	@Override
	public GetByIdTransmissionResponse getById(int id) {
		this.transmissionBusinessRules.checkFoundId(id);
		Transmission transmission=transmissionRepository.findById(id).get();
		 GetByIdTransmissionResponse getByIdTransmissionResponse=this.modelMapperService.forResponse().map(transmission, GetByIdTransmissionResponse.class);
		 return getByIdTransmissionResponse;
	}

	@Override
	public void add(CreateTransmissionRequest createTransmissionRequest) {
		this.transmissionBusinessRules.checkIfTransmissionName(createTransmissionRequest.getName());
		Transmission transmission=modelMapperService.forRequest().map(createTransmissionRequest, Transmission.class);
		this.transmissionRepository.save(transmission);
		
	}

	@Override
	public void update(UpdateTransmissionRequest updateTransmissionRequest,int id) {
		this.transmissionBusinessRules.checkFoundId(id);
		this.transmissionBusinessRules.checkIfTransmissionName(updateTransmissionRequest.getName());
		Transmission transmissionUpdate=this.modelMapperService.forRequest().map(updateTransmissionRequest,Transmission.class);
		transmissionRepository.save(transmissionUpdate);
		
	}

	@Override
	public void delete(int id) {
		this.transmissionBusinessRules.checkFoundId(id);
		this.transmissionRepository.deleteById(id);
		
	}
	
	
}
