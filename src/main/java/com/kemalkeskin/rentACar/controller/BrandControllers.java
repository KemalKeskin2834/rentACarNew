package com.kemalkeskin.rentACar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalkeskin.rentACar.business.abstracts.BrandService;
import com.kemalkeskin.rentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/brands")
@AllArgsConstructor
public class BrandControllers {
	
	@Autowired
	private BrandService brandService;
	
	@GetMapping("/getall")
	public List<Brand>getAll(){
		return brandService.getAll();
	}

}
