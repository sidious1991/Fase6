package it.uniroma2.fase6.controller.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.uniroma2.fase6.controller.RetrospectiveReportService;
import it.uniroma2.fase6.model.RetrospectiveReport;
import it.uniroma2.fase6.model.rest.DTOresponse;
import it.uniroma2.fase6.repositories.RetrospectiveReportRepository;

@Service("RetrospectiveReportService")
public class RetrospectiveReportServiceImpl implements RetrospectiveReportService {

	@Autowired
	RetrospectiveReportRepository retrospectiveReportRepository;
	
	
	@Override
	public ResponseEntity<DTOresponse> createRetrospectiveReport(String retrospectiveReportId, String conclusion,
			String lastModified, List<Integer> ids, List<String> priorityList,List<String> descriptionList) {
		
		RetrospectiveReport measurementGoal= new RetrospectiveReport(retrospectiveReportId, conclusion,
				lastModified, ids,  priorityList,descriptionList);
		retrospectiveReportRepository.save(measurementGoal);
				
		DTOresponse dtoresponse = new DTOresponse();		
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse,HttpStatus.OK);
			
		return response;
	}
	
	@Override
	public ResponseEntity<DTOresponse> deleteRetrospectiveReport(String retrospectiveReportId) {
	
		
		retrospectiveReportRepository.delete(retrospectiveReportRepository.findOne(retrospectiveReportId));
		
		return null;
	}
	@Override
	public ResponseEntity<DTOresponse> deleteAllRetrospectiveReport() {
	
		
		retrospectiveReportRepository.delete(retrospectiveReportRepository.findAll());
		
		return null;
	}
	
	@Override
	public ResponseEntity<DTOresponse> getRetrospectiveReports() {
		
		List<RetrospectiveReport> retrospectiveReport = retrospectiveReportRepository.findAll();
		
		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setRetrospectiveReports(retrospectiveReport);
		
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse,HttpStatus.OK);	
	
		return response;
		
	}
}
