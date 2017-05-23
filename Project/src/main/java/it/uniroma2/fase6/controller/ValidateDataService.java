package it.uniroma2.fase6.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import it.uniroma2.fase6.model.rest.DTOresponse;

public interface ValidateDataService {
	ResponseEntity<DTOresponse> createValidateData(String dataId,List<String>data,String WorkFlowInstanceId,String strategyRef,String metricRef);

	

	ResponseEntity<DTOresponse> getValidateData();

}
