package com.kemalkeskin.rentACar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.business.abstracts.CarService;
import com.kemalkeskin.rentACar.dataAccess.abstracts.CarRepository;
import com.kemalkeskin.rentACar.entities.concretes.Car;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
	@Autowired
	private CarRepository carRepository;

	@Override
	public List<Car> getAll() {
		
		return carRepository.findAll();
	}

}
