package it.uniroma2.fase6.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Strategy {

	@Id
	private String strategyId;
	private String strategyName;
	private List<String> context;
	private List<String> assumptions;
	private String description;
	private String creationDate;
	private String lastModified;
	private String timeFrame;
	private int version;

	@DBRef
	private List<Goal> goalRef;

	public Strategy(String strategyId,String strategyName, List<String> context,
			List<String> assumptions, String description, String creationDate,
			String lastModified, String timeFrame, int version,
			List<Goal> goalRef) {
		super();
		this.strategyId = strategyId;
		this.strategyName= strategyName;
		this.context = context;
		this.assumptions = assumptions;
		this.description = description;
		this.creationDate = creationDate;
		this.lastModified = lastModified;
		this.timeFrame = timeFrame;
		this.version = version;
		this.goalRef = goalRef;
	}

	public List<Goal> getGoalRef() {
		return goalRef;
	}

	public void setGoalRef(List<Goal> goalRef) {
		this.goalRef = goalRef;
	}

	public Strategy() {

	}

	public Strategy(String strategyId) {

		this.strategyId = strategyId;

	}

	public String getStrategyName() {
		return strategyName;
	}

	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}

	public Strategy(String strategyId,String strategyName, List<String> context,
			List<String> assumptions, String description, String creationDate,
			String lastModified, String timeFrame, int version) {
		super();
		this.strategyId = strategyId;
		this.strategyName= strategyName;
		this.context = context;
		this.assumptions = assumptions;
		this.description = description;
		this.creationDate = creationDate;
		this.lastModified = lastModified;
		this.timeFrame = timeFrame;
		this.version = version;
	}

	

	public String getStrategyId() {
		return strategyId;
	}

	public void setStrategyId(String strategyId) {
		this.strategyId = strategyId;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
