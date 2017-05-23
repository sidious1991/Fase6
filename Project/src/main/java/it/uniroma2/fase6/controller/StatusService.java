package it.uniroma2.fase6.controller;

import org.springframework.http.ResponseEntity;

import it.uniroma2.fase6.model.rest.DTOresponse;

public interface StatusService {

	ResponseEntity<DTOresponse> createStatus(String statusId, String status,
			String creationDate, String lastModified, String goalRef,String projectRef);

	ResponseEntity<DTOresponse> getStatus();
	
	ResponseEntity<DTOresponse> getStatusByProjectId(String projectRef);

	ResponseEntity<DTOresponse> deleteAllStatus();

	ResponseEntity<DTOresponse> deleteStatus(String statusId);

}
