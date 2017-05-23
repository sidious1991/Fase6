package it.uniroma2.fase6.controller.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.uniroma2.fase6.controller.StatusService;
import it.uniroma2.fase6.model.Goal;
import it.uniroma2.fase6.model.Project;
import it.uniroma2.fase6.model.Status;
import it.uniroma2.fase6.model.rest.DTOresponse;
import it.uniroma2.fase6.repositories.GoalRepository;
import it.uniroma2.fase6.repositories.ProjectRepository;
import it.uniroma2.fase6.repositories.StatusRepository;

@Service("StatusService")
public class StatusServiceImpl implements StatusService{
@Autowired
StatusRepository statusRepository;

@Autowired
GoalRepository goalRepository;
@Autowired
ProjectRepository projectRepository;

	@Override
	public ResponseEntity<DTOresponse> createStatus(String statusId,
			String status, String creationDate, String lastModified,
			String goalRef, String projectRef ) {
		// TODO Auto-generated method stub
		Goal temp= new Goal();
		Project temp2= new Project();
		if(goalRepository.findOne(goalRef)!=null)
			temp=goalRepository.findOne(goalRef);				
		
		if (temp==null){
			return new ResponseEntity<DTOresponse>(new DTOresponse(),HttpStatus.BAD_REQUEST);
		}
		if(projectRepository.findOne(projectRef)!=null)
			temp2=projectRepository.findOne(projectRef);				
		if (temp2==null){
			return new ResponseEntity<DTOresponse>(new DTOresponse(),HttpStatus.BAD_REQUEST);
		}
		
		Status stat= new Status(statusId,status,creationDate,lastModified,temp,temp2);
		statusRepository.save(stat);
				
		DTOresponse dtoresponse = new DTOresponse();		
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse,HttpStatus.OK);
			
		return response;
		
		
		
	}

	@Override
	public ResponseEntity<DTOresponse> getStatus() {
		// TODO Auto-generated method stub
		List<Status> status = statusRepository.findAll();

		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setStatus(status);

		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(
				dtoresponse, HttpStatus.OK);

		return response;
	}
	@Override
	public ResponseEntity<DTOresponse> getStatusByProjectId(String projectRef){

		List<Status> temp = statusRepository.findAll();
		List<Status> status = new ArrayList<Status>();
		
		for(Status s: temp){
			if (s.getProjectRef().getProjectID().equals(projectRef))
				status.add(s);
		}
		
		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setStatus(status);
	
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(
				dtoresponse, HttpStatus.OK);
	
		return response;
	}	
	
	@Override
	public ResponseEntity<DTOresponse> deleteAllStatus() {
		// TODO Auto-generated method stub
			statusRepository.delete(statusRepository.findAll());
		
		return null;
	}

	@Override
	public ResponseEntity<DTOresponse> deleteStatus(String statusId) {
		// TODO Auto-generated method stub
		statusRepository.delete(statusRepository.findOne(statusId));
		return null;
	}

	
}
