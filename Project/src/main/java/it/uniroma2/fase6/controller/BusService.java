package it.uniroma2.fase6.controller;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;

import it.uniroma2.fase6.model.rest.DTOresponse;

public interface  BusService {
	ResponseEntity<DTOresponse> createReport(String payload)throws JSONException;
	ResponseEntity<DTOresponse> getSendingOutcomes()throws JSONException;
	ResponseEntity<DTOresponse> getChartData() throws JSONException;
	ResponseEntity<DTOresponse> getScheduleChartData() throws JSONException;
	ResponseEntity<DTOresponse> getUsersFromBus() throws JSONException;
}
