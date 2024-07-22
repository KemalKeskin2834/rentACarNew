package com.kemalkeskin.rentACar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalkeskin.rentACar.business.DTOs.requests.car.CreateCarRequest;
import com.kemalkeskin.rentACar.business.DTOs.requests.car.UpdateCarRequest;
import com.kemalkeskin.rentACar.business.DTOs.responses.car.GetAllCarResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.car.GetByIdCarResponse;
import com.kemalkeskin.rentACar.business.abstracts.CarService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarControllers {
	@Autowired
	private CarService carService;
	
	 @GetMapping("/getall")
	public List<GetAllCarResponse> getAll(){
		return carService.getAll();
	}
	
	 @GetMapping("/getbyid/{id}")
	public GetByIdCarResponse getById(@PathVariable int id){
		return carService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(@Valid @RequestBody CreateCarRequest createCarRequest) {
		this.carService.add(createCarRequest);
	}
	
	@PutMapping("/update")
	public void update(@Valid @RequestBody UpdateCarRequest updateCarRequest) {
		this.carService.update(updateCarRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.carService.delete(id);
	} 

}
