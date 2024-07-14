package com.kemalkeskin.rentACar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalkeskin.rentACar.business.DTOs.responses.brand.GetAllBrandResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.brand.GetByIdBrandResponse;
import com.kemalkeskin.rentACar.business.abstracts.BrandService;

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

}
