package it.uniroma2.fase6.model.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DTOStatus extends DTO {
	private static final long serialVersionUID = 1L;

	@JsonInclude(Include.NON_NULL)
	private String statusId;
	@JsonInclude(Include.NON_NULL)
	private String status;
	@JsonInclude(Include.NON_NULL)
	private String creationDate;
	@JsonInclude(Include.NON_NULL)
	private String lastModified;

	@JsonInclude(Include.NON_NULL)
	private String goalRef;
	@JsonInclude(Include.NON_NULL)
	private String projectRef;

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

	public String getGoalRef() {
		return goalRef;
	}

	public void setGoalRef(String goalRef) {
		this.goalRef = goalRef;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getProjectRef() {
		return projectRef;
	}

	public void setProjectRef(String projectRef) {
		this.projectRef = projectRef;
	}

}
