package it.uniroma2.fase6.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import it.uniroma2.fase6.model.rest.DTOresponse;

public interface RetrospectiveReportService {

	ResponseEntity<DTOresponse> createRetrospectiveReport(String retrospectiveReportId,
			String conclusion, String lastModified, List<Integer> ids, List<String> priorityList, 
			List<String> descriptionList);
	ResponseEntity<DTOresponse> getRetrospectiveReports();
	ResponseEntity<DTOresponse> deleteRetrospectiveReport(String retrospectiveReportId);
	ResponseEntity<DTOresponse> deleteAllRetrospectiveReport();
}
