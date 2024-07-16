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

import com.kemalkeskin.rentACar.business.DTOs.requests.brand.CreateBrandRequest;
import com.kemalkeskin.rentACar.business.DTOs.requests.brand.UpdateBrandRequest;
import com.kemalkeskin.rentACar.business.DTOs.responses.brand.GetAllBrandResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.brand.GetByIdBrandResponse;
import com.kemalkeskin.rentACar.business.abstracts.BrandService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/brands")
@AllArgsConstructor
public class BrandControllers {
	
	@Autowired
	private BrandService brandService;
	
	@GetMapping("/getall")
	public List<GetAllBrandResponse>getAll(){
		return brandService.getAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id){
		return brandService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(@Valid @RequestBody CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	
	@PutMapping("/update")
	public void update(@Valid @RequestBody UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}

}
