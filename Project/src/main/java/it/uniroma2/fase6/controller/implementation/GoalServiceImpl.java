package it.uniroma2.fase6.controller.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.uniroma2.fase6.controller.GoalService;
import it.uniroma2.fase6.model.Goal;
import it.uniroma2.fase6.model.MeasurementGoal;
import it.uniroma2.fase6.model.Strategy;
import it.uniroma2.fase6.model.rest.DTOresponse;
import it.uniroma2.fase6.repositories.GoalRepository;
import it.uniroma2.fase6.repositories.MeasurementGoalRepository;
import it.uniroma2.fase6.repositories.StrategyRepository;


@Service("GoalService")
public class GoalServiceImpl implements GoalService {

	@Autowired
	GoalRepository goalRepository;
	@Autowired
	MeasurementGoalRepository measurementGoalRepository;
	@Autowired
	StrategyRepository strategyRepository;
	
	@Override
	public ResponseEntity<DTOresponse> createGoal(String goalId,String goalName, int version,
			String creationDate, String lastModified, String timeFrame,
			String object, int magnitude, String focus, String costraint,
			String organizationalScope, String description,
			List<String> measurementRef, List<String> strategyRef) {
				
		List<MeasurementGoal> temp= new ArrayList<MeasurementGoal>();
		List<Strategy> temp2= new ArrayList<Strategy>();
		for( String s :measurementRef ){
			if(measurementGoalRepository.findOne(s)!=null)
				temp.add(measurementGoalRepository.findOne(s));				
		}
		if (temp.size()==0){
			return new ResponseEntity<DTOresponse>(new DTOresponse(),HttpStatus.BAD_REQUEST);
		}
		
		for( String s : strategyRef ){
			if(strategyRepository.findOne(s)!=null)
				temp2.add(strategyRepository.findOne(s));				
		}
		if (temp2.size()==0){
			return new ResponseEntity<DTOresponse>(new DTOresponse(),HttpStatus.BAD_REQUEST);
		}		
		Goal goal= new Goal(goalId,goalName,version,creationDate,lastModified,timeFrame,
				 object, magnitude,focus,costraint,
				organizationalScope, description,temp,temp2);
		goalRepository.save(goal);
				
		DTOresponse dtoresponse = new DTOresponse();		
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse,HttpStatus.OK);
			
		return response;
	}

	@Override
	public ResponseEntity<DTOresponse> createGoal(String goalId,String goalName, int version,
			String creationDate, String lastModified, String timeFrame,
			String object, int magnitude, String focus, String costraint,
			String organizationalScope, String description) {
		// TODO Auto-generated method stub
		Goal goal = new Goal(goalId,goalName,version,
				 creationDate,  lastModified,  timeFrame,
				 object,  magnitude,  focus,  costraint,
				 organizationalScope,  description);
		goalRepository.save(goal);
		DTOresponse dtoresponse = new DTOresponse();
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(
				dtoresponse, HttpStatus.OK);

		return response;
	}

	@Override
	public ResponseEntity<DTOresponse> getGoals() {
		List<Goal> goals = goalRepository.findAll();

		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setGoals(goals);

		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(
				dtoresponse, HttpStatus.OK);

		return response;
	}

	@Override
	public ResponseEntity<DTOresponse> deleteAllGoal() {
		goalRepository.delete(goalRepository.findAll());
		
		return null;
	}

	@Override
	public ResponseEntity<DTOresponse> deleteGoal(String goalId) {
		goalRepository.delete(goalRepository.findOne(goalId));

		return null;
	}

}
