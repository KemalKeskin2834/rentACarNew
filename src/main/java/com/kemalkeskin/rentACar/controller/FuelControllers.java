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

import com.kemalkeskin.rentACar.business.DTOs.requests.fuel.CreateFuelRequest;
import com.kemalkeskin.rentACar.business.DTOs.requests.fuel.UpdateFuelRequest;
import com.kemalkeskin.rentACar.business.DTOs.responses.fuel.GetAllFuelResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.fuel.GetByIdFuelResponse;
import com.kemalkeskin.rentACar.business.abstracts.FuelService;

import jakarta.validation.Valid;
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
	@PostMapping("/add")
	public void add(@Valid @RequestBody CreateFuelRequest createFuelRequest) {
		this.fuelService.add(createFuelRequest);
	}
	
	@PutMapping("/update/{id}")
	public void update(@Valid @RequestBody UpdateFuelRequest updateFuelRequest,@PathVariable int id) {
		this.fuelService.update(updateFuelRequest, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.fuelService.delete(id);
	}
}
