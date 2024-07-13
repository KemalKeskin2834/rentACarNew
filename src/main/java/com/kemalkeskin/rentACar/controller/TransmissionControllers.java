package com.kemalkeskin.rentACar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemalkeskin.rentACar.business.abstracts.TransmissionService;
import com.kemalkeskin.rentACar.entities.concretes.Transmission;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/transmission")
@AllArgsConstructor
public class TransmissionControllers {

	@Autowired
	private TransmissionService transmissionService;
	
	@GetMapping("/getall")
	public List<Transmission>getAll(){
		return transmissionService.getAll();
	}
}
