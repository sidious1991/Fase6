package it.uniroma2.fase6.model.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import it.uniroma2.fase6.model.Goal;

public class DTOStrategy extends DTO{
	
	private static final long serialVersionUID = 1L;
	
	@JsonInclude(Include.NON_NULL)
	private String strategyId;
	@JsonInclude(Include.NON_NULL)
	private String strategyName;
	@JsonInclude(Include.NON_NULL)
	private String description;
	@JsonInclude(Include.NON_NULL)
	private String creationDate;
	@JsonInclude(Include.NON_NULL)
	private String lastModified;
	@JsonInclude(Include.NON_NULL)
	private String timeFrame;
	
	@JsonInclude(Include.NON_NULL)		
	private List<String> context;
	@JsonInclude(Include.NON_NULL)
	private List<String> assumptions;
	
	@JsonInclude(Include.NON_NULL)

	private int version;
	
	@JsonInclude(Include.NON_NULL)
	private List<String> goalRef;
	
	public List<String> getGoalRef() {
		return goalRef;
	}

	public void setGoalRef(List<String> goalRef) {
		this.goalRef = goalRef;
	}

	public String getStrategyId() {
		return strategyId;
	}

	public String getStrategyName() {
		return strategyName;
	}

	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	
	public List<String> getContext() {
		return context;
	}

	public void setContext(List<String> context) {
		this.context = context;
	}

	public List<String> getAssumptions() {
		return assumptions;
	}

	public void setAssumptions(List<String> assumptions) {
		this.assumptions = assumptions;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setStrategyId(String strategyId) {
		this.strategyId = strategyId;
	}
	
	

}
