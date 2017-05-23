package it.uniroma2.fase6.controller.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.uniroma2.fase6.controller.ProjectService;
import it.uniroma2.fase6.model.Goal;
import it.uniroma2.fase6.model.Project;
import it.uniroma2.fase6.model.Status;
import it.uniroma2.fase6.model.rest.DTOresponse;
import it.uniroma2.fase6.repositories.GoalRepository;
import it.uniroma2.fase6.repositories.ProjectRepository;

@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	GoalRepository goalRepository;

	@Override
	public ResponseEntity<DTOresponse> createProject(String projectID,
			String name, String creationDate, String description,
			String version, List<String> goalRef) {
		// TODO Auto-generated method stub
		List<Goal> temp = new ArrayList<Goal>();
		for (String s : goalRef) {
			if (goalRepository.findOne(s) != null)
				temp.add(goalRepository.findOne(s));
		}
		if (temp.size() == 0) {
			return new ResponseEntity<DTOresponse>(new DTOresponse(),
					HttpStatus.BAD_REQUEST);
		}

		Project project = new Project(projectID, name, creationDate, description, version, temp);
		projectRepository.save(project);

		DTOresponse dtoresponse = new DTOresponse();
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(
				dtoresponse, HttpStatus.OK);

		return response;
	}

	@Override
	public ResponseEntity<DTOresponse> getProject() {
		// TODO Auto-generated method stub
		List<Project> project = projectRepository.findAll();

		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setProject(project);

		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(
				dtoresponse, HttpStatus.OK);

		return response;
	}

	@Override
	public ResponseEntity<DTOresponse> deleteAllProject() {
		// TODO Auto-generated method stub
		projectRepository.delete(projectRepository.findAll());
		return null;
	}

	@Override
	public ResponseEntity<DTOresponse> deleteProject(String projectID) {
		// TODO Auto-generated method stub
		projectRepository.delete(projectRepository.findOne(projectID));
		return null;
	}

}
