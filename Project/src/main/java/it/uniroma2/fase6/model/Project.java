package it.uniroma2.fase6.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Project {
	
	@Id
	//definisce l'id del progetto 
	private String projectID;
	//definisce il nome del progetto
	private String name;
	//definisce la data di creazione 
	private String creationDate;
	//definise la descrizione del progetto
	private String description;
	//indica la versione del progetto
	private String version;
	
	@DBRef
	private List<Goal> goalRef;
	
	

	public Project() {
	}

	public Project(String projectID, String name, String creationDate, String description,
			String version, List<Goal> goalRef) {
		super();
		this.projectID = projectID;
		this.name = name;
		this.creationDate = creationDate;
		this.goalRef = goalRef;
		this.description = description;
		this.version = version;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Goal> getgoalRef() {
		return goalRef;
	}

	public void setgoalRef(ArrayList<Goal> goalRef) {
		this.goalRef = goalRef;
	}
		
}
