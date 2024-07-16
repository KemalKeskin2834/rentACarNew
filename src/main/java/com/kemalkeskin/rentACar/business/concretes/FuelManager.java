package com.kemalkeskin.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.business.DTOs.requests.fuel.CreateFuelRequest;
import com.kemalkeskin.rentACar.business.DTOs.requests.fuel.UpdateFuelRequest;
import com.kemalkeskin.rentACar.business.DTOs.responses.fuel.GetAllFuelResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.fuel.GetByIdFuelResponse;
import com.kemalkeskin.rentACar.business.abstracts.FuelService;
import com.kemalkeskin.rentACar.business.rules.FuelBusinessRules;
import com.kemalkeskin.rentACar.core.mapper.ModelMapperService;
import com.kemalkeskin.rentACar.dataAccess.abstracts.FuelRepository;
import com.kemalkeskin.rentACar.entities.concretes.Fuel;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuelManager implements FuelService{
	
	private FuelRepository fuelRepository;
	private ModelMapperService modelMapperService;
	private FuelBusinessRules fuelBusinessRules;
	
	@Override
	public List<GetAllFuelResponse> getAll() {
	
		List<Fuel>fuels=fuelRepository.findAll();
		List<GetAllFuelResponse>getAllFuelResponses=fuels.stream().map(fuel->modelMapperService.forResponse().map(fuel, GetAllFuelResponse.class)).collect(Collectors.toList());
		return getAllFuelResponses;
	}

	@Override
	public GetByIdFuelResponse getById(int id) {
		
		fuelBusinessRules.checkFoundId(id);
		Fuel fuel=fuelRepository.findById(id).get();
		 GetByIdFuelResponse getByIdfuelResponse=this.modelMapperService.forResponse().map(fuel, GetByIdFuelResponse.class);
		 return getByIdfuelResponse;
	}

	@Override
	public void add(CreateFuelRequest createFuelRequest) {
		this.fuelBusinessRules.checkIfFuelName(createFuelRequest.getName());
		Fuel fuel=modelMapperService.forRequest().map(createFuelRequest, Fuel.class);
		this.fuelRepository.save(fuel);
		
	}

	@Override
	public void update(UpdateFuelRequest updateFuelRequest,int id) {
		this.fuelBusinessRules.checkIfFuelName(updateFuelRequest.getName());
		this.fuelBusinessRules.checkFoundId(id);
		Fuel fuelUpdate=this.modelMapperService.forRequest().map(updateFuelRequest,Fuel.class);
		fuelRepository.save(fuelUpdate);
		
	}

	@Override
	public void delete(int id) {
		this.fuelBusinessRules.checkFoundId(id);
		this.fuelRepository.deleteById(id);
		
	}

}
