package com.kemalkeskin.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.core.exception.BusinessException;
import com.kemalkeskin.rentACar.dataAccess.abstracts.ModelRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class ModelBusinessRules {
	
	private ModelRepository modelRepository;

	public void checkFoundId(int id) {

		if(!modelRepository.existsById(id)) {
			throw new BusinessException("don't found id");
		}
	}
	
	public void checkIfModel(String name) {
		if(this.modelRepository.existsByName(name)) {
			throw new BusinessException("this model name avaliable");
		}
	}
}
