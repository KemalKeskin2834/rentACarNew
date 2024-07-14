package com.kemalkeskin.rentACar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalkeskin.rentACar.business.DTOs.responses.fuel.GetAllFuelResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.fuel.GetByIdFuelResponse;
import com.kemalkeskin.rentACar.business.abstracts.FuelService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/fuels")
@AllArgsConstructor
public class FuelControllers {
	@Autowired
	private FuelService fuelService;
	
	@GetMapping("/getall")
	public List<GetAllFuelResponse>getAll(){
		return fuelService.getAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public GetByIdFuelResponse getById(@PathVariable int id){
		return fuelService.getById(id);
	}

}
