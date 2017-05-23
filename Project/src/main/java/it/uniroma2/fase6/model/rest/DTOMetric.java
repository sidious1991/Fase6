package it.uniroma2.fase6.model.rest;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DTOMetric  extends DTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonInclude(Include.NON_NULL)
	private String id;
	@JsonInclude(Include.NON_NULL)
	private String metricId;
	@JsonInclude(Include.NON_NULL)
	private String description;
	@JsonInclude(Include.NON_NULL)
	private String count; // Numero di misure associate alla metrica
	@JsonInclude(Include.NON_NULL)
	private List<String> metricUnits;
	@JsonInclude(Include.NON_NULL)
	private String scaleType;
	@JsonInclude(Include.NON_NULL)
	private String limH;
	@JsonInclude(Include.NON_NULL)
	private String limL;
	@JsonInclude(Include.NON_NULL)
	private String creationDate;
	@JsonInclude(Include.NON_NULL)
	private String lastModified;
	@JsonInclude(Include.NON_NULL)
	int version;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getScaleType() {
		return scaleType;
	}
	public void setScaleType(String scaleType) {
		this.scaleType = scaleType;
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
	public void setMetricUnits(List<String> metricUnits) {
		this.metricUnits = metricUnits;
	}
	
}
