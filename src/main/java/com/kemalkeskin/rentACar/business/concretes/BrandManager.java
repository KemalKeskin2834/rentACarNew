package com.kemalkeskin.rentACar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.business.abstracts.BrandService;
import com.kemalkeskin.rentACar.dataAccess.abstracts.BrandRepository;
import com.kemalkeskin.rentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService{
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public List<Brand> getAll() {
		
		return brandRepository.findAll();
	}

}
