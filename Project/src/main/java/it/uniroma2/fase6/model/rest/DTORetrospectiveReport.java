package it.uniroma2.fase6.model.rest;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DTORetrospectiveReport  extends DTO{

	
	private static final long serialVersionUID = 1L;
	@JsonInclude(Include.NON_NULL)
	private String retrospectiveReportId;
	@JsonInclude(Include.NON_NULL)
	private String conclusion;
	@JsonInclude(Include.NON_NULL)
	private String lastModified;
	@JsonInclude(Include.NON_NULL)
	private List<Integer> ids;
	@JsonInclude(Include.NON_NULL)
	private List<String> priorityList;
	@JsonInclude(Include.NON_NULL)
	private List<String> descriptionList;

	public String getRetrospectiveReportId() {
		return retrospectiveReportId;
	}
	public void setRetrospectiveReportId(String retrospectiveReportId) {
		this.retrospectiveReportId = retrospectiveReportId;
	}
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public List<String> getPriorityList() {
		return priorityList;
	}
	public void setPriorityList(List<String> priorityList) {
		this.priorityList = priorityList;
	}
	public List<String> getDescriptionList() {
		return descriptionList;
	}
	public void setDescriptionList(List<String> descriptionList) {
		this.descriptionList = descriptionList;
	}
	
}
