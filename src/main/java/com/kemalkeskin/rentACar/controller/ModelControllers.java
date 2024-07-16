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

import com.kemalkeskin.rentACar.business.DTOs.requests.model.CreateModelRequest;
import com.kemalkeskin.rentACar.business.DTOs.requests.model.UpdateModelRequest;
import com.kemalkeskin.rentACar.business.DTOs.responses.model.GetAllModelResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.model.GetByIdModelResponse;
import com.kemalkeskin.rentACar.business.abstracts.ModelService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/models")
@AllArgsConstructor
public class ModelControllers {
	@Autowired
	private ModelService modelService;
	
	@GetMapping("/getall")
	public List<GetAllModelResponse>getAll(){
		return modelService.getAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public GetByIdModelResponse getById(@PathVariable int id){
		return modelService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(@Valid @RequestBody CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
	}
	
	@PutMapping("/update/{id}")
	public void update(@Valid @RequestBody UpdateModelRequest updateModelRequest,@PathVariable int id) {
		this.modelService.update(updateModelRequest, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.modelService.delete(id);
	}
}
