package it.uniroma2.fase6.controller.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.uniroma2.fase6.controller.MetricService;
import it.uniroma2.fase6.model.Metric;
import it.uniroma2.fase6.model.rest.DTOresponse;
import it.uniroma2.fase6.repositories.MetricRepository;

@Service("MetricService")
public class MetricServiceImpl implements MetricService {

	@Autowired
	MetricRepository metricRepository;
	
	@Override
	public ResponseEntity<DTOresponse> createMetric(String metricId, String description, String count, List<String> metricUnits, String scaleType, String limH, String limL, String creationDate,String lastModified, int version) {
		
		Metric metric= new Metric(metricId, description, count, metricUnits, scaleType, limH, limL, creationDate,lastModified, version);
		
		metricRepository.save(metric);
				
		DTOresponse dtoresponse = new DTOresponse();		
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse,HttpStatus.OK);
			
		return response;
	}

	@Override
	public ResponseEntity<DTOresponse> deleteMetric(String metricId) {
	
		
		metricRepository.delete(metricRepository.findOne(metricId));
		
		return null;
	}
	
	@Override
	public ResponseEntity<DTOresponse> getMetrics() {
		
		List<Metric> metrics = metricRepository.findAll();
		
		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setMetrics(metrics);
		
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse,HttpStatus.OK);	
	
		return response;
		
	}
}
