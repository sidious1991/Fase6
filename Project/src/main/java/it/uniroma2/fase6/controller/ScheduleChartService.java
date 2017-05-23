package it.uniroma2.fase6.controller;

import org.springframework.http.ResponseEntity;

import it.uniroma2.fase6.model.rest.DTOresponse;

public interface ScheduleChartService {

	ResponseEntity<DTOresponse> createScheduleChart(String scheduleId,String fase, String startDate,String lastDate);
	ResponseEntity<DTOresponse> getScheduleChart();
	ResponseEntity<DTOresponse> deleteAllScheduleChart();
	ResponseEntity<DTOresponse> deleteScheduleChart(String scheduleId);

	
	
}
