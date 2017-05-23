package it.uniroma2.fase6.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Status {
	@Id
	//definisce id di riferimento allo status dell'analisi
	private String statusId;
	// definisce se lo status è {accepted, rejected , unchecked}
	private String status;
	//data della creazione
	private String creationDate;
	//data dell'ultima modifica sensibile
	private String lastModified;
	//riferimento dello status all'id del gaol analizzato
	@DBRef
	private Goal goalRef;
	@DBRef
	private Project projectRef; 
	
	public Status(String statusId, String status, String creationDate,
			String lastModified, Goal goalRef,Project projectRef) {
		super();
		this.statusId = statusId;
		this.status = status;
		this.creationDate = creationDate;
		this.lastModified = lastModified;
		this.goalRef = goalRef;
		this.projectRef=projectRef;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public Goal getGoalRef() {
		return goalRef;
	}

	public void setGoalRef(Goal goalRef) {
		this.goalRef = goalRef;
	}

	public Project getProjectRef() {
		return projectRef;
	}

	public void setProjectRef(Project projectRef) {
		this.projectRef = projectRef;
	}


}
