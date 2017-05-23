package it.uniroma2.fase6.model.rest;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import it.uniroma2.fase6.model.Goal;

public class DTOProject  extends DTO{

	/**
	 * 
	 */		
	private static final long serialVersionUID = 1L;
	
	@JsonInclude(Include.NON_NULL)
	private String projectID;
	@JsonInclude(Include.NON_NULL)
	private String name;
	@JsonInclude(Include.NON_NULL)
	private String creationDate;
	@JsonInclude(Include.NON_NULL)
	private String description;
	@JsonInclude(Include.NON_NULL)
	private String version;
	@JsonInclude(Include.NON_NULL)
	public ArrayList<String> goalRef;
	
	
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
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public ArrayList<String> getgoalRef() {
		return goalRef;
	}
	public void setgoalRef(ArrayList<String> goalRef) {
		this.goalRef = goalRef;
	}
	

		
}
