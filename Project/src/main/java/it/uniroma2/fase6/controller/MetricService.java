package it.uniroma2.fase6.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import it.uniroma2.fase6.model.rest.DTOresponse;

public interface MetricService {
	
	ResponseEntity<DTOresponse> createMetric(String metricId,String description, String count, List<String> metricUnits, String scaleType, String limH, String limL, String creationDate,String lastModified, int version );
	ResponseEntity<DTOresponse> getMetrics();
	ResponseEntity<DTOresponse> deleteMetric(String metricId);
}
