package com.kemalkeskin.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.core.exception.BusinessException;
import com.kemalkeskin.rentACar.dataAccess.abstracts.FuelRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FuelBusinessRules {
	
	private FuelRepository fuelRepository;
	
	public void checkFoundId(int id) {

		if(!fuelRepository.existsById(id)) {
			throw new BusinessException("don't found id");
		}
	}
	
	public void checkIfFuelName(String name) {
		if(this.fuelRepository.existsByName(name)) {
			throw new BusinessException("this fuel name avaliable");
		}
	}
	

}
