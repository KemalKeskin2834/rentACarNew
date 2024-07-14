package com.kemalkeskin.rentACar.business.abstracts;

import java.util.List;

import com.kemalkeskin.rentACar.business.DTOs.responses.brand.GetAllBrandResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.brand.GetByIdBrandResponse;

public interface BrandService {
	
	List<GetAllBrandResponse>getAll();
	
	GetByIdBrandResponse getById(int id);

}
