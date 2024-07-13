package com.kemalkeskin.rentACar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.business.abstracts.TransmissionService;
import com.kemalkeskin.rentACar.dataAccess.abstracts.TransmissionRepository;
import com.kemalkeskin.rentACar.entities.concretes.Transmission;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class TransmissionManager implements TransmissionService{
	@Autowired
	private TransmissionRepository transmissionRepository;

	@Override
	public List<Transmission> getAll() {
	
		return transmissionRepository.findAll();
	}
	
	
}
