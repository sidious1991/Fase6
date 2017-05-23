package it.uniroma2.fase6.model.rest;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class DTOMeasurementGoal  extends DTO{

	/**
	 * 
	 */		
	   
	private static final long serialVersionUID = 1L;
			
	@JsonInclude(Include.NON_NULL)
	private String measurementGoalId;
	@JsonInclude(Include.NON_NULL)
	private String object;
	@JsonInclude(Include.NON_NULL)
    private String purpose;
	@JsonInclude(Include.NON_NULL)
    private String qualityFocus;
	@JsonInclude(Include.NON_NULL)
    private String viewpoint;
	@JsonInclude(Include.NON_NULL)
    private String context;
	@JsonInclude(Include.NON_NULL)
    private String creationDate;
	@JsonInclude(Include.NON_NULL)
    private String lastModified;
	@JsonInclude(Include.NON_NULL)
	private String interpretationModel;
	@JsonInclude(Include.NON_NULL)
    private int version;
	@JsonInclude(Include.NON_NULL)    
	public List<String> questionsRef;
	@JsonInclude(Include.NON_NULL)
	public List<String> metricsRef;
	
	public String getMeasurementGoalId() {
		return measurementGoalId;
	}
	public void setMeasurementGoalId(String measurementGoalId) {
		this.measurementGoalId = measurementGoalId;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getQualityFocus() {
		return qualityFocus;
	}
	public void setQualityFocus(String qualityFocus) {
		this.qualityFocus = qualityFocus;
	}
	public String getViewpoint() {
		return viewpoint;
	}
	public void setViewpoint(String viewpoint) {
		this.viewpoint = viewpoint;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
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
	public List<String> getQuestionsRef() {
		return questionsRef;
	}
	public void setQuestionsRef(List<String> questionsRef) {
		this.questionsRef = questionsRef;
	}
	public List<String> getMetricsRef() {
		return metricsRef;
	}
	public void setMetricsRef(List<String> metricsRef) {
		this.metricsRef = metricsRef;
	}
	public String getInterpretationModel() {
		return interpretationModel;
	}
	public void setInterpretationModel(String interpretationModel) {
		this.interpretationModel = interpretationModel;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
				
}
