package it.uniroma2.fase6.model.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DTOScheduleChart extends DTO{
	
private static final long serialVersionUID = 1L;
@JsonInclude(Include.NON_NULL)
private String scheduleId;
@JsonInclude(Include.NON_NULL)
private String fase;
@JsonInclude(Include.NON_NULL)
private String startDate;
@JsonInclude(Include.NON_NULL)
private String lastDate;



public String getScheduleId() {
	return scheduleId;
}
public void setScheduleId(String scheduleId) {
	this.scheduleId = scheduleId;
}
public String getFase() {
	return fase;
}
public void setFase(String fase) {
	this.fase = fase;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getLastDate() {
	return lastDate;
}
public void setLastDate(String lastDate) {
	this.lastDate = lastDate;
}
	


}
