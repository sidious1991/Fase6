package it.uniroma2.fase6.controller.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.uniroma2.fase6.controller.ValidateDataService;
import it.uniroma2.fase6.model.Goal;
import it.uniroma2.fase6.model.Metric;
import it.uniroma2.fase6.model.Strategy;
import it.uniroma2.fase6.model.ValidateData;
import it.uniroma2.fase6.model.rest.DTOresponse;
import it.uniroma2.fase6.repositories.MetricRepository;
import it.uniroma2.fase6.repositories.StrategyRepository;
import it.uniroma2.fase6.repositories.ValidateDataRepository;

@Service("ValidateDataService")
public class ValidateDataServiceImp implements ValidateDataService {
	
	@Autowired
	ValidateDataRepository validateDataRepository;
	@Autowired
	MetricRepository metricRepository;
	@Autowired
	StrategyRepository strategyRepository;
	
	
	@Override
	public ResponseEntity<DTOresponse> createValidateData(String dataId,
			List<String> data,String workFlowInstanceId ,String strategyRef,
			String metricRef) {
		
		Strategy temp= new Strategy();
		Metric temp2= new Metric();
		
			if(strategyRepository.findOne(strategyRef)!=null)
				temp=(strategyRepository.findOne(strategyRef));				
		
		if (temp==null){
			return new ResponseEntity<DTOresponse>(new DTOresponse(),HttpStatus.NOT_FOUND);
		}
		
		
			if(metricRepository.findOne(metricRef)!=null)
				temp2=(metricRepository.findOne(metricRef));				
		
		if (temp2==null){
			return new ResponseEntity<DTOresponse>(new DTOresponse(),HttpStatus.BAD_REQUEST);
		}		
		
		ValidateData dataSet= new ValidateData(dataId,data,workFlowInstanceId,temp,temp2);
		
		validateDataRepository.save(dataSet);
		DTOresponse dtoresponse = new DTOresponse();		
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse,HttpStatus.OK);
			
		return response;
	}

	@Override
	public ResponseEntity<DTOresponse> getValidateData() {
		List<ValidateData> datas = validateDataRepository.findAll();

		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setValidateData(datas);

		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(
				dtoresponse, HttpStatus.OK);

		return response;
	}

}
