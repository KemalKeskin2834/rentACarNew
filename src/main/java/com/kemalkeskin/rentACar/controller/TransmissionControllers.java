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

import com.kemalkeskin.rentACar.business.DTOs.requests.transmission.CreateTransmissionRequest;
import com.kemalkeskin.rentACar.business.DTOs.requests.transmission.UpdateTransmissionRequest;
import com.kemalkeskin.rentACar.business.DTOs.responses.transmission.GetAllTransmissionResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.transmission.GetByIdTransmissionResponse;
import com.kemalkeskin.rentACar.business.abstracts.TransmissionService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/transmission")
@AllArgsConstructor
public class TransmissionControllers {

	@Autowired
	private TransmissionService transmissionService;
	
	@GetMapping("/getall")
	public List<GetAllTransmissionResponse>getAll(){
		return transmissionService.getAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public GetByIdTransmissionResponse getById(@PathVariable int id){
		return transmissionService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(@Valid @RequestBody CreateTransmissionRequest createTransmissionRequest) {
		this.transmissionService.add(createTransmissionRequest);
	}
	
	@PutMapping("/update/{id}")
	public void update(@Valid @RequestBody UpdateTransmissionRequest updateTransmissionRequest,@PathVariable int id) {
		this.transmissionService.update(updateTransmissionRequest, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		this.transmissionService.delete(id);
	}
}
