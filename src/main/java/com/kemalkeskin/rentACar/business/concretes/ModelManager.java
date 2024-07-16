package com.kemalkeskin.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kemalkeskin.rentACar.business.DTOs.requests.model.CreateModelRequest;
import com.kemalkeskin.rentACar.business.DTOs.requests.model.UpdateModelRequest;
import com.kemalkeskin.rentACar.business.DTOs.responses.model.GetAllModelResponse;
import com.kemalkeskin.rentACar.business.DTOs.responses.model.GetByIdModelResponse;
import com.kemalkeskin.rentACar.business.abstracts.ModelService;
import com.kemalkeskin.rentACar.business.rules.ModelBusinessRules;
import com.kemalkeskin.rentACar.core.mapper.ModelMapperService;
import com.kemalkeskin.rentACar.dataAccess.abstracts.ModelRepository;
import com.kemalkeskin.rentACar.entities.concretes.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	private ModelBusinessRules modelBusinessRules;

	@Override
	public List<GetAllModelResponse> getAll() {
		
		List<Model>models=modelRepository.findAll();
		List<GetAllModelResponse>getAllModelResponses=models.stream().map(model->modelMapperService.forResponse().map(model, GetAllModelResponse.class)).collect(Collectors.toList());
		return getAllModelResponses;
	}

	@Override
	public GetByIdModelResponse getById(int id) {
		this.modelBusinessRules.checkFoundId(id);
		Model model=modelRepository.findById(id).get();
		 GetByIdModelResponse getByIdModelResponse=this.modelMapperService.forResponse().map(model, GetByIdModelResponse.class);
		 return getByIdModelResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		this.modelBusinessRules.checkIfModel(createModelRequest.getName());
		Model model=modelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);
		
		
	}

	@Override
	public void update(UpdateModelRequest updateModelRequest,int id) {
		this.modelBusinessRules.checkFoundId(id);
		Model modelUpdate=this.modelMapperService.forRequest().map(updateModelRequest,Model.class);
		modelRepository.save(modelUpdate);
		
	}

	@Override
	public void delete(int id) {
		this.modelBusinessRules.checkFoundId(id);
		this.modelRepository.deleteById(id);
		
	}
}
