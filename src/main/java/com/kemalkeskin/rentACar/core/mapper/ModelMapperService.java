package com.kemalkeskin.rentACar.core.mapper;

import org.modelmapper.ModelMapper;


public interface ModelMapperService {
	
	ModelMapper forResponse();
	ModelMapper forRequest();

}
