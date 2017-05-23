package it.uniroma2.fase6.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Metric {
	@Id	
	private String metricId;
	
	private String description;
	private String count; // Numero di misure associate alla metrica+++da cancellare
	private List<String> metricUnits;//potrebbe non servire una lista-- per adesso non cambiare
	private String scaleType;
	private String limH;//è stato sostituito range con limite inferiore e superiore
	private String limL;
	private String creationDate;
	private String lastModified;
	private int version;
	
	public Metric(){
		
	}
	
	
	public Metric(String metricId, String description, String count,
			List<String> metricUnits, String scaleType, String limH,
			String limL, String creationDate, String lastModified, int version) {
		super();
		this.metricId = metricId;
		this.description = description;
		this.count = count;
		this.metricUnits = metricUnits;
		this.scaleType = scaleType;
		this.limH = limH;
		this.limL = limL;
		this.creationDate = creationDate;
		this.lastModified = lastModified;
		this.version = version;
	}


	

	public String getMetricId() {
		return metricId;
	}
	public void setMetricId(String metricId) {
		this.metricId = metricId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public List<String> getMetricUnits() {
		return metricUnits;
	}
	public void setMetricUnits(List<String> metricUnits) {
		this.metricUnits = metricUnits;
	}
	public String getScaleType() {
		return scaleType;
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


	public void setBaseType(){
		this.scaleType="BASE";
	}
	public void setDeriveType(){
		this.scaleType="DERIVE";
	}

	public String getLimH() {
		return limH;
	}

	public void setLimH(String limH) {
		this.limH = limH;
	}

	public String getLimL() {
		return limL;
	}

	public void setLimL(String limL) {
		this.limL = limL;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setScaleType(String scaleType) {
		this.scaleType = scaleType;
	}
		
}
