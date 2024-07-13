package com.kemalkeskin.rentACar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalkeskin.rentACar.business.abstracts.ModelService;
import com.kemalkeskin.rentACar.entities.concretes.Model;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/models")
@AllArgsConstructor
public class ModelControllers {
	@Autowired
	private ModelService modelService;
	
	@GetMapping("/getall")
	public List<Model>getAll(){
		return modelService.getAll();
	}
}
