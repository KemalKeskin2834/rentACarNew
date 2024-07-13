package com.kemalkeskin.rentACar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalkeskin.rentACar.business.abstracts.CarService;
import com.kemalkeskin.rentACar.entities.concretes.Car;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cars")
@AllArgsConstructor
public class CarControllers {
	@Autowired
	private CarService carService;
	
	@GetMapping("/getall")
	public List<Car>getAll(){
		return carService.getAll();
	}

}
