package com.kemalkeskin.rentACar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalkeskin.rentACar.business.DTOs.responses.car.GetAllCarResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.car.GetByIdCarResponse;
import com.kemalkeskin.rentACar.business.abstracts.CarService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarControllers {
	@Autowired
	private CarService carService;
	
	@GetMapping("/getall")
	public List<GetAllCarResponse>getAll(){
		return carService.getAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public GetByIdCarResponse getById(@PathVariable int id){
		return carService.getById(id);
	}

}
