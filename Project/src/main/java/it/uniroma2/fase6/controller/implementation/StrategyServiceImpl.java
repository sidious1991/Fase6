package it.uniroma2.fase6.controller.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.uniroma2.fase6.controller.StrategyService;
import it.uniroma2.fase6.model.Goal;
import it.uniroma2.fase6.model.Strategy;
import it.uniroma2.fase6.model.rest.DTOresponse;
import it.uniroma2.fase6.repositories.GoalRepository;
import it.uniroma2.fase6.repositories.StrategyRepository;

@Service("StrategyService")
public class StrategyServiceImpl implements StrategyService {

	@Autowired
	StrategyRepository strategyRepository;
	@Autowired
	GoalRepository goalRepository;

	@Override
	public ResponseEntity<DTOresponse> createStrategy(String strategyId,String strategyName,
			List<String> context, List<String> assumptions, String description,
			String creationDate, String lastModified, String timeFrame,
			int version,List<String> goalRef) {
		// TODO Auto-generated method stub
		List<Goal> temp= new ArrayList<Goal>();
		for( String s : goalRef ){
			if(goalRepository.findOne(s)!=null)
				temp.add(goalRepository.findOne(s));				
		}
		if (temp.size()==0){
			return new ResponseEntity<DTOresponse>(new DTOresponse(),HttpStatus.BAD_REQUEST);
		}
		
		Strategy strategy = new Strategy(strategyId,strategyName, context, assumptions,description, creationDate, lastModified, timeFrame, version, temp);
		strategyRepository.save(strategy);
		DTOresponse dtoresponse = new DTOresponse();
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(
				dtoresponse, HttpStatus.OK);

		return response;
	}
	@Override
	public ResponseEntity<DTOresponse> createStrategy(String strategyId,String strategyName,
			List<String> context, List<String> assumptions, String description,
			String creationDate, String lastModified, String timeFrame,
			int version){
		Strategy strategy = new Strategy(strategyId, strategyName,context, assumptions,
				description, creationDate, lastModified, timeFrame, version);
		strategyRepository.save(strategy);
		DTOresponse dtoresponse = new DTOresponse();
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(
				dtoresponse, HttpStatus.OK);

		return response;
		
	}
	@Override
	public ResponseEntity<DTOresponse> getStrategies() {
		List<Strategy> strategies = strategyRepository.findAll();

		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setStrategies(strategies);

		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(
				dtoresponse, HttpStatus.OK);

		return response;

	}

	@Override
	public ResponseEntity<DTOresponse> deleteStrategy(String strategyId) {
		// TODO Auto-generated method stub

		strategyRepository.delete(strategyRepository.findOne(strategyId));

		return null;
	}

}
