package it.uniroma2.fase6.model.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import it.uniroma2.fase6.model.Bus;
import it.uniroma2.fase6.model.Goal;
import it.uniroma2.fase6.model.MeasurementGoal;
import it.uniroma2.fase6.model.Metric;
import it.uniroma2.fase6.model.Project;
import it.uniroma2.fase6.model.Question;
import it.uniroma2.fase6.model.RetrospectiveReport;
import it.uniroma2.fase6.model.ScheduleChart;
import it.uniroma2.fase6.model.SendingOutComesFase6;
import it.uniroma2.fase6.model.Status;
import it.uniroma2.fase6.model.Strategy;
import it.uniroma2.fase6.model.ValidateData;

public class DTOresponse extends DTO {

	public DTOresponse(DTO dto, String string) {

		this.error = dto.getError();
		this.message = string;

	}

	public DTOresponse() {

	}

	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}
	

	public List<Metric> getMetrics() {
		return metrics;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<MeasurementGoal> getMeasurementGoals() {
		return measurementGoals;
	}

	public void setMeasurementGoals(List<MeasurementGoal> measurementGoals) {
		this.measurementGoals = measurementGoals;
	}

	public List<Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonInclude(Include.NON_NULL)
	private List<Metric> metrics;

	@JsonInclude(Include.NON_NULL)
	private List<Question> questions;

	@JsonInclude(Include.NON_NULL)
	private List<Goal> goals;

	@JsonInclude(Include.NON_NULL)
	private List<MeasurementGoal> measurementGoals;

	@JsonInclude(Include.NON_NULL)
	private List<Strategy> strategies;

	@JsonInclude(Include.NON_NULL)
	private List<Status> status;
	
	@JsonInclude(Include.NON_NULL)
	private List<RetrospectiveReport> retrospectiveReports;

	@JsonInclude(Include.NON_NULL)
	private List<Project> project;
	
	@JsonInclude(Include.NON_NULL)
	private List<ValidateData> validateData;
	
	@JsonInclude(Include.NON_NULL)
	private List<ScheduleChart> scheduleChart;
	
	@JsonInclude(Include.NON_NULL)
	private List<SendingOutComesFase6> sendingOutcomesFase6;
	
	

	public List<SendingOutComesFase6> getSendingOutcomesFase6() {
		return sendingOutcomesFase6;
	}

	public void setSendingOutcomesFase6(
			List<SendingOutComesFase6> sendingOutcomesFase6) {
		this.sendingOutcomesFase6 = sendingOutcomesFase6;
	}

	public List<ScheduleChart> getScheduleChart() {
		return scheduleChart;
	}

	public void setScheduleChart(List<ScheduleChart> scheduleChart) {
		this.scheduleChart = scheduleChart;
	}

	public List<ValidateData> getValidateData() {
		return validateData;
	}

	public void setValidateData(List<ValidateData> validateData) {
		this.validateData = validateData;
	}

	@JsonInclude(Include.NON_NULL)
	private Bus busResponse;

	public Bus getBusResponse() {
		return busResponse;
	}

	public void setBusResponse(Bus busResponse) {
		this.busResponse = busResponse;
	}

	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	public List<Strategy> getStrategies() {
		return strategies;
	}

	public void setStrategies(List<Strategy> strategies) {
		this.strategies = strategies;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}
	public List<RetrospectiveReport> getRetrospectiveReports() {
		return retrospectiveReports;
	}

	public void setRetrospectiveReports(List<RetrospectiveReport> retrospectiveReports) {
		this.retrospectiveReports = retrospectiveReports;
	}
	
}
