package it.uniroma2.fase6.model.rest;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DTOGoal extends DTO {

private static final long serialVersionUID = 1L;
	
	@JsonInclude(Include.NON_NULL)
	private String goalId;
	@JsonInclude(Include.NON_NULL)
	private String goalName;
	@JsonInclude(Include.NON_NULL)
	private int version;
	@JsonInclude(Include.NON_NULL)
	private String creationDate;
	@JsonInclude(Include.NON_NULL)
	private String lastModified;
	@JsonInclude(Include.NON_NULL)
	private String timeFrame;
	@JsonInclude(Include.NON_NULL)
	private String description;
	@JsonInclude(Include.NON_NULL)		
	private String object;
	@JsonInclude(Include.NON_NULL)		
		private int magnitude;
	@JsonInclude(Include.NON_NULL)		
		private String focus;
	@JsonInclude(Include.NON_NULL)		
		private String costraint;
	@JsonInclude(Include.NON_NULL)		
	private String organizationalScope;
	
	@JsonInclude(Include.NON_NULL)
	private List<String> measurementRef;
	@JsonInclude(Include.NON_NULL)
	private List<String> strategyRef;
	
	public List<String> getMeasurementRef() {
		return measurementRef;
	}
	public void setMeasurementRef(List<String> measurementRef) {
		this.measurementRef = measurementRef;
	}
	public List<String> getStrategyRef() {
		return strategyRef;
	}
	public void setStrategyRef(List<String> strategyRef) {
		this.strategyRef = strategyRef;
	}
	public String getGoalId() {
		return goalId;
	}
	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
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
	public String getTimeFrame() {
		return timeFrame;
	}
	public void setTimeFrame(String timeFrame) {
		this.timeFrame = timeFrame;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public int getMagnitude() {
		return magnitude;
	}
	public void setMagnitude(int magnitude) {
		this.magnitude = magnitude;
	}
	public String getFocus() {
		return focus;
	}
	public void setFocus(String focus) {
		this.focus = focus;
	}
	public String getCostraint() {
		return costraint;
	}
	public void setCostraint(String costraint) {
		this.costraint = costraint;
	}
	public String getOrganizationalScope() {
		return organizationalScope;
	}
	public void setOrganizationalScope(String organizationalScope) {
		this.organizationalScope = organizationalScope;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getGoalName() {
		return goalName;
	}
	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}
	
	
}
