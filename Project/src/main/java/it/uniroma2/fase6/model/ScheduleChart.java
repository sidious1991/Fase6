package it.uniroma2.fase6.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ScheduleChart {
@Id
private String scheduleId;
private String fase;
private String startDate;
private String lastDate;

public ScheduleChart() {
	super();
}

public ScheduleChart(String scheduleId, String fase, String startDate,
		String lastDate) {
	super();
	this.scheduleId = scheduleId;
	this.fase = fase;
	this.startDate = startDate;
	this.lastDate = lastDate;
}

public String getscheduleId() {
	return scheduleId;
}

public void setscheduleId(String scheduleId) {
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
