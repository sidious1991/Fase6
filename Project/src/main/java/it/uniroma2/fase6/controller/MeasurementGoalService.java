package it.uniroma2.fase6.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import it.uniroma2.fase6.model.rest.DTOresponse;

public interface MeasurementGoalService {

	ResponseEntity<DTOresponse> createMeasurementGoal(String measurementGoalId, String object, String purpose, String qualityFocus,
			String viewpoint, String context, String creationDate, String lastModified, String interpretationModel,
			int version);
	ResponseEntity<DTOresponse> createMeasurementGoal(String measurementGoalId, String object, String purpose, String qualityFocus,
			String viewpoint, String context, String creationDate, String lastModified, String interpretationModel,
			int version, List<String> questionsRef, List<String> metricsRef);
	ResponseEntity<DTOresponse> getMeasurementGoals();
	public ResponseEntity<DTOresponse> deleteAllMeasurementGoal();
	ResponseEntity<DTOresponse> deleteMeasurementGoal(String measurementGoalId);
}
