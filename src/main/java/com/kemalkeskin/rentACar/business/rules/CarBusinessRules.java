package com.kemalkeskin.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.core.exception.BusinessException;
import com.kemalkeskin.rentACar.dataAccess.abstracts.CarRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class CarBusinessRules  {
	
	private CarRepository carRepository;
	
	public void checkFoundId(int id) {

		if(!carRepository.existsById(id)) {
			throw new BusinessException("don't found id");
		}
	}

	
	public void checkIfPlate(String plate) {
		if(this.carRepository.existsByPlate(plate)) {
			throw new BusinessException("this plate avaliable");
		}
	}
	
	
	
	



}
