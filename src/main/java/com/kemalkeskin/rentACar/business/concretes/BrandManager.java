package com.kemalkeskin.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.business.DTOs.requests.brand.CreateBrandRequest;
import com.kemalkeskin.rentACar.business.DTOs.requests.brand.UpdateBrandRequest;
import com.kemalkeskin.rentACar.business.DTOs.responses.brand.GetAllBrandResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.brand.GetByIdBrandResponse;
import com.kemalkeskin.rentACar.business.abstracts.BrandService;
import com.kemalkeskin.rentACar.business.rules.BrandBusinessRules;
import com.kemalkeskin.rentACar.core.mapper.ModelMapperService;
import com.kemalkeskin.rentACar.dataAccess.abstracts.BrandRepository;
import com.kemalkeskin.rentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService{
	
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;

	@Override
	public List<GetAllBrandResponse> getAll() {
		
		List<Brand>brands=brandRepository.findAll();
		List<GetAllBrandResponse>getAllBrandResponses=brands.stream().map(brand->this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class)).collect(Collectors.toList());
		return getAllBrandResponses;
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		this.brandBusinessRules.checkIfId(id);
		Brand brand=brandRepository.findById(id).get();
		 GetByIdBrandResponse getByIdBrandResponse=this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		 return getByIdBrandResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.checkIfBrandName(createBrandRequest.getName());
		Brand brand=modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
	
		this.brandBusinessRules.checkIfBrandName(updateBrandRequest.getName());
		Brand brandUpdate=this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
		brandRepository.save(brandUpdate);
		
	}

	@Override
	public void delete(int id) {
		this.brandBusinessRules.checkIfId(id);
		this.brandRepository.deleteById(id);
		
	}

}
