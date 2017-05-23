package it.uniroma2.fase6.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import it.uniroma2.fase6.model.rest.DTOresponse;

public interface ProjectService  {
	ResponseEntity<DTOresponse> createProject(String projectID, String name, String creationDate, String description,
			String version, List<String> goalRef);

	ResponseEntity<DTOresponse> getProject();

	public ResponseEntity<DTOresponse> deleteAllProject();

	ResponseEntity<DTOresponse> deleteProject(String projectID);

}
