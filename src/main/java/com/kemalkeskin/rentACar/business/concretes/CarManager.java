package com.kemalkeskin.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.business.DTOs.responses.car.GetAllCarResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.car.GetByIdCarResponse;
import com.kemalkeskin.rentACar.business.abstracts.CarService;
import com.kemalkeskin.rentACar.core.mapper.ModelMapperService;
import com.kemalkeskin.rentACar.dataAccess.abstracts.CarRepository;
import com.kemalkeskin.rentACar.entities.concretes.Car;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
	
	private CarRepository carRepository;
	private ModelMapperService modelService;

	@Override
	public List<GetAllCarResponse> getAll() {
		
		List<Car>cars=carRepository.findAll();
		List<GetAllCarResponse>getAllCarResponses=cars.stream().map(car->this.modelService.forResponse().map(car, GetAllCarResponse.class)).collect(Collectors.toList());
		return getAllCarResponses;
	}

	@Override
	public GetByIdCarResponse getById(int id) {
		 Optional<Car> car=carRepository.findById(id);
		 if(!car.isPresent()) {
	
			 new RuntimeException("hata verdik");
		 }
		 GetByIdCarResponse getByIdCarResponse=this.modelService.forResponse().map(car, GetByIdCarResponse.class);
		 return getByIdCarResponse;
		
		 
				
	}

}
