package com.kemalkeskin.rentACar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalkeskin.rentACar.business.DTOs.responses.transmission.GetAllTransmissionResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.transmission.GetByIdTransmissionResponse;
import com.kemalkeskin.rentACar.business.abstracts.TransmissionService;

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
}
