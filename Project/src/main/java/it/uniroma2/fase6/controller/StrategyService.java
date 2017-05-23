package it.uniroma2.fase6.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;

import it.uniroma2.fase6.model.rest.DTOresponse;

public interface StrategyService {
	ResponseEntity<DTOresponse> createStrategy(String strategyId,String strategyName,
			List<String> context, List<String> assumptions, String description,
			String creationDate, String lastModified, String timeFrame,
			int version, List<String> goalRef);

	ResponseEntity<DTOresponse> createStrategy(String strategyId,String strategyName,
			List<String> context, List<String> assumptions, String description,
			String creationDate, String lastModified, String timeFrame,
			int version);
			
	ResponseEntity<DTOresponse> getStrategies();

	ResponseEntity<DTOresponse> deleteStrategy(String strategyId);

}
