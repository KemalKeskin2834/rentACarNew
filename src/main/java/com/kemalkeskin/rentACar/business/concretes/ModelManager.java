package com.kemalkeskin.rentACar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.business.abstracts.ModelService;
import com.kemalkeskin.rentACar.dataAccess.abstracts.ModelRepository;
import com.kemalkeskin.rentACar.entities.concretes.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
	@Autowired
	private ModelRepository modelRepository;

	@Override
	public List<Model> getAll() {
	
		return modelRepository.findAll();
	}
}
