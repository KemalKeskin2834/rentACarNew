package com.kemalkeskin.rentACar.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.business.DTOs.responses.model.GetAllModelResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.model.GetByIdModelResponse;
import com.kemalkeskin.rentACar.business.abstracts.ModelService;
import com.kemalkeskin.rentACar.core.mapper.ModelMapperService;
import com.kemalkeskin.rentACar.dataAccess.abstracts.ModelRepository;
import com.kemalkeskin.rentACar.entities.concretes.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllModelResponse> getAll() {
		
		List<Model>models=modelRepository.findAll();
		List<GetAllModelResponse>getAllModelResponses=models.stream().map(model->modelMapperService.forResponse().map(model, GetAllModelResponse.class)).collect(Collectors.toList());
		return getAllModelResponses;
	}

	@Override
	public GetByIdModelResponse getById(int id) {
		Optional<Model> model=modelRepository.findById(id);
		 if(!model.isPresent()) {
	
			 new RuntimeException("hata verdik");
		 }
		 GetByIdModelResponse getByIdModelResponse=this.modelMapperService.forResponse().map(model, GetByIdModelResponse.class);
		 return getByIdModelResponse;
	}
}
