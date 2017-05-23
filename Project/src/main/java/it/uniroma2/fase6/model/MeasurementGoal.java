package it.uniroma2.fase6.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MeasurementGoal {
	
	@Id
	private String measurementGoalId;
	
    private String object;//object dell'organizational goal
    private String purpose;
    private String qualityFocus;//focus dell'organizational goal
    private String viewpoint;//organization scope dell'organizational goal
    private String context;//costraint
    //private String description;//non necessario
    private String creationDate;
    private String lastModified;
    //private String timeFrame;//non necessario
    private String interpretationModel;//magnitude + time frame dell'organizational goal 
    private int version;
    //@DBRef
    private List<Question> questionsRef;
    @DBRef
    private List<Metric> metricsRef;
    
	public MeasurementGoal(){
			
	}
	
	
	public MeasurementGoal(String measurementGoalId, String object, String purpose, String qualityFocus,
			String viewpoint, String context, String creationDate, String lastModified, String interpretationModel,
			int version) {
		super();
		this.measurementGoalId = measurementGoalId;
		this.object = object;
		this.purpose = purpose;
		this.qualityFocus = qualityFocus;
		this.viewpoint = viewpoint;
		this.context = context;
		this.creationDate = creationDate;
		this.lastModified = lastModified;
		this.interpretationModel = interpretationModel;
		this.version = version;
	}


	public MeasurementGoal(String measurementGoalId, String object, String purpose, String qualityFocus,
			String viewpoint, String context, String creationDate, String lastModified, String interpretationModel,
			int version, List<Question> questionsRef, List<Metric> metricsRef) {
		super();
		this.measurementGoalId = measurementGoalId;
		this.object = object;
		this.purpose = purpose;
		this.qualityFocus = qualityFocus;
		this.viewpoint = viewpoint;
		this.context = context;
		this.creationDate = creationDate;
		this.lastModified = lastModified;
		this.interpretationModel = interpretationModel;
		this.version = version;
		this.questionsRef = questionsRef;
		this.metricsRef = metricsRef;
	}


	public String getMeasurementGoalId() {
		return measurementGoalId;
	}
	public void setMeasurementGoalId(String measurementGoalId) {
		this.measurementGoalId = measurementGoalId;
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
	
	public List<Question> getQuestionsRef() {
		return questionsRef;
	}
	public void setQuestionsRef(List<Question> questionsRef) {
		this.questionsRef = questionsRef;
	}
	public List<Metric> getMetricsRef() {
		return metricsRef;
	}
	public void setMetricsRef(List<Metric> metricsRef) {
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
	
}
