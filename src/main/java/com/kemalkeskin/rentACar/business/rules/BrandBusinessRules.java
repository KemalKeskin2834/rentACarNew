package com.kemalkeskin.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.core.exception.BusinessException;
import com.kemalkeskin.rentACar.dataAccess.abstracts.BrandRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
	private BrandRepository brandRepository;

	
	public void checkIfId(int id) {
		
		if(!brandRepository.existsById(id)) {
			throw new BusinessException("don't found id");
		}
	}
	
	public void checkIfBrandName(String name) {
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("brand name avaliable");
		}
	}
}
