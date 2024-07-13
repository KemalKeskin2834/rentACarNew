package com.kemalkeskin.rentACar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalkeskin.rentACar.business.abstracts.FuelService;
import com.kemalkeskin.rentACar.entities.concretes.Fuel;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/fuels")
@AllArgsConstructor
public class FuelControllers {
	@Autowired
	private FuelService fuelService;
	
	@GetMapping("/getall")
	public List<Fuel>getAll(){
		return fuelService.getAll();
	}

}
