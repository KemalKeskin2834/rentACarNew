package com.kemalkeskin.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.core.exception.BusinessException;
import com.kemalkeskin.rentACar.dataAccess.abstracts.TransmissionRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class TransmissionBusinessRules {
	
	private TransmissionRepository  transmissionRepository;
	
	public void checkFoundId(int id) {

		if(!transmissionRepository.existsById(id)) {
			throw new BusinessException("don't found id");
		}
	}
	public void checkIfTransmissionName(String name) {
		if(this.transmissionRepository.existsByName(name)) {
			throw new BusinessException("this transmission namen avaliable");
		}
	}

}
