package com.kemalkeskin.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.business.DTOs.responses.fuel.GetAllFuelResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.fuel.GetByIdFuelResponse;
import com.kemalkeskin.rentACar.business.abstracts.FuelService;
import com.kemalkeskin.rentACar.core.mapper.ModelMapperService;
import com.kemalkeskin.rentACar.dataAccess.abstracts.FuelRepository;
import com.kemalkeskin.rentACar.entities.concretes.Fuel;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuelManager implements FuelService{
	
	private FuelRepository fuelRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllFuelResponse> getAll() {
	
		List<Fuel>fuels=fuelRepository.findAll();
		List<GetAllFuelResponse>getAllFuelResponses=fuels.stream().map(fuel->modelMapperService.forResponse().map(fuel, GetAllFuelResponse.class)).collect(Collectors.toList());
		return getAllFuelResponses;
	}

	@Override
	public GetByIdFuelResponse getById(int id) {
		Optional<Fuel> fuel=fuelRepository.findById(id);
		 if(!fuel.isPresent()) {
	
			 new RuntimeException("hata verdik");
		 }
		 GetByIdFuelResponse getByIdfuelResponse=this.modelMapperService.forResponse().map(fuel, GetByIdFuelResponse.class);
		 return getByIdfuelResponse;
	}

}
