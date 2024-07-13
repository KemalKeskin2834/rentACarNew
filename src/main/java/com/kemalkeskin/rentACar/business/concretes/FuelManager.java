package com.kemalkeskin.rentACar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.business.abstracts.FuelService;
import com.kemalkeskin.rentACar.dataAccess.abstracts.FuelRepository;
import com.kemalkeskin.rentACar.entities.concretes.Fuel;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuelManager implements FuelService{
	@Autowired
	private FuelRepository fuelRepository;
	
	@Override
	public List<Fuel> getAll() {
	
		return fuelRepository.findAll();
	}

}
