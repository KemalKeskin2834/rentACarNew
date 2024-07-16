package com.kemalkeskin.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.business.DTOs.requests.car.CreateCarRequest;
import com.kemalkeskin.rentACar.business.DTOs.requests.car.UpdateCarRequest;
import com.kemalkeskin.rentACar.business.DTOs.responses.car.GetAllCarResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.car.GetByIdCarResponse;
import com.kemalkeskin.rentACar.business.abstracts.CarService;
import com.kemalkeskin.rentACar.business.rules.CarBusinessRules;
import com.kemalkeskin.rentACar.core.mapper.ModelMapperService;
import com.kemalkeskin.rentACar.dataAccess.abstracts.CarRepository;
import com.kemalkeskin.rentACar.entities.concretes.Car;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
	
	private CarRepository carRepository;
	private ModelMapperService modelMapperService;
	private CarBusinessRules carBusinessRules;

	@Override
	public List<GetAllCarResponse> getAll() {
		
		List<Car>cars=carRepository.findAll();
		List<GetAllCarResponse>getAllCarResponses=cars.stream().map(car->this.modelMapperService.forResponse().map(car, GetAllCarResponse.class)).collect(Collectors.toList());
		return getAllCarResponses;
	}

	@Override
	public GetByIdCarResponse getById(int id) {
		carBusinessRules.checkFoundId(id);
		 Car car=carRepository.findById(id).get();
		 GetByIdCarResponse getByIdCarResponse=this.modelMapperService.forResponse().map(car, GetByIdCarResponse.class);
		 return getByIdCarResponse;
		
		 
				
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		
		this.carBusinessRules.checkIfPlate(createCarRequest.getPlate());
		Car car=modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carRepository.save(car);
		
	}

	@Override
	public void update(UpdateCarRequest updateCarRequest) {
	
		this.carBusinessRules.checkIfPlate(updateCarRequest.getPlate());
		carBusinessRules.checkFoundId(updateCarRequest.getId());
		Car carUpdate=this.modelMapperService.forRequest().map(updateCarRequest,Car.class);
		carRepository.save(carUpdate);
		
		
	}

	@Override
	public void delete(int id) {
		carBusinessRules.checkFoundId(id);
		this.carRepository.deleteById(id);
		
	}

}
