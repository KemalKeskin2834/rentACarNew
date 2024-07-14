package com.kemalkeskin.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.business.DTOs.responses.brand.GetAllBrandResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.brand.GetByIdBrandResponse;
import com.kemalkeskin.rentACar.business.abstracts.BrandService;
import com.kemalkeskin.rentACar.core.mapper.ModelMapperService;
import com.kemalkeskin.rentACar.dataAccess.abstracts.BrandRepository;
import com.kemalkeskin.rentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService{
	
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllBrandResponse> getAll() {
		
		List<Brand>brands=brandRepository.findAll();
		List<GetAllBrandResponse>getAllBrandResponses=brands.stream().map(brand->this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class)).collect(Collectors.toList());
		return getAllBrandResponses;
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Optional<Brand> brand=brandRepository.findById(id);
		 if(!brand.isPresent()) {
	
			 new RuntimeException("hata verdik");
		 }
		 GetByIdBrandResponse getByIdBrandResponse=this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		 return getByIdBrandResponse;
	}

}
