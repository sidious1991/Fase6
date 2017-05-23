package it.uniroma2.fase6.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import it.uniroma2.fase6.model.rest.DTOresponse;

public interface GoalService {

	ResponseEntity<DTOresponse> createGoal(String goalId, String goalName,int version,
			String creationDate, String lastModified, String timeFrame,
			String object, int magnitude, String focus, String costraint,
			String organizationalScope, String description,
			List<String> measurementRef, List<String> strategyRef);

	ResponseEntity<DTOresponse> createGoal(String goalId,String goalName, int version, String creationDate,
			String lastModified, String timeFrame, String object,
			int magnitude, String focus, String costraint,
			String organizationalScope, String description);

	ResponseEntity<DTOresponse> getGoals();

	public ResponseEntity<DTOresponse> deleteAllGoal();

	ResponseEntity<DTOresponse> deleteGoal(String goalId);
}
