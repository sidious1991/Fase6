package it.uniroma2.fase6.rest;

import java.io.UnsupportedEncodingException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma2.fase6.controller.BusService;
import it.uniroma2.fase6.controller.ProjectService;
import it.uniroma2.fase6.controller.RetrospectiveReportService;
import it.uniroma2.fase6.controller.ScheduleChartService;
import it.uniroma2.fase6.controller.StatusService;
import it.uniroma2.fase6.controller.ValidateDataService;
import it.uniroma2.fase6.model.rest.DTOresponse;

@RestController
@RequestMapping("/")
public class RestPresentation implements ErrorController {

	//	@Autowired
	//	MetricService metricService;
	//	@Autowired
	//	QuestionService questionService;
	//	@Autowired
	//	MeasurementGoalService measurementGoalService;
	//	@Autowired
	//	StrategyService strategyService;
	//	@Autowired
	//	GoalService goalService;
	@Autowired
	StatusService statusService;
	@Autowired
	ProjectService projectService;
	@Autowired
	RetrospectiveReportService retrospectiveReportService;
	@Autowired
	BusService busService;
	@Autowired
	ValidateDataService validateDataService;
	@Autowired
	ScheduleChartService scheduleChartService;

	String redirectLocal = "<html><head>" +
			"<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/\" />"
			+ "</head></html>";

	String redirectLocalTomcat = "<html><head>" +
			"<meta http-equiv=\"refresh\" content=\"0; url=http://localhost:8080/Fase6\" />"
			+ "</head></html>";

	String redirectProd = "<html><head>" +
			"<meta http-equiv=\"refresh\" content=\"0; url=http://qips-test.sweng.uniroma2.it/Fase6\" />"
			+ "</head></html>";

	//	@Autowired
	//	SendingOutComesFase6Service sendingOutComesFase6Service;

	//	@RequestMapping(value = "/getQuestions", method = RequestMethod.GET)
	//	public ResponseEntity<DTOresponse> getQuestions() {
	//		return questionService.getQuestions();
	//	}
	//
	//	@RequestMapping(value = "/createQuestion", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> createQuestion(
	//			@RequestBody DTOQuestion dtoQuestion) {
	//		
	//		return questionService.createQuestion(dtoQuestion.getQuestionId(),
	//				dtoQuestion.getDescription(), dtoQuestion.getCreationDate(),
	//				dtoQuestion.getLastModified(), dtoQuestion.getTimeFrame(),
	//				dtoQuestion.getVersion(), dtoQuestion.getFocus());
	//
	//	}
	//	@RequestMapping(value = "/deleteQuestion", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> deleteQuestion(
	//			@RequestBody DTOQuestion dtoQuestion) {
	//
	//		return questionService.deleteQuestion(dtoQuestion.getQuestionId());
	//
	//	}
	//	
	//	@RequestMapping(value = "/deleteAllQuestion", method = RequestMethod.GET)
	//	public ResponseEntity<DTOresponse> deleteAllQuestion() {
	//
	//		return questionService.deleteAllQuestion();
	//
	//	}

	//	@RequestMapping(value = "/getMetrics", method = RequestMethod.GET)
	//	public ResponseEntity<DTOresponse> getMetrics() {
	//		return metricService.getMetrics();
	//	}
	//
	//	@RequestMapping(value = "/createMetric", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> createMetric(
	//			@RequestBody DTOMetric dtoMetric) {
	//
	//		return metricService.createMetric(dtoMetric.getMetricId(),
	//				dtoMetric.getDescription(), dtoMetric.getCount(),
	//				dtoMetric.getMetricUnits(), dtoMetric.getScaleType(),
	//				dtoMetric.getLimH(), dtoMetric.getLimL(),
	//				dtoMetric.getCreationDate(),dtoMetric.getLastModified() ,dtoMetric.getVersion());
	//
	//	}

	//	@RequestMapping(value = "/deleteMetric", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> deleteMetric(
	//			@RequestBody DTOMetric dtoMetric) {
	//
	//		return metricService.deleteMetric(dtoMetric.getMetricId());
	//
	//	}
	//
	//	@RequestMapping(value = "/getMeasurementGoals", method = RequestMethod.GET)
	//	public ResponseEntity<DTOresponse> getMeasurementGoals() {
	//		return measurementGoalService.getMeasurementGoals();
	//	}

	//	@RequestMapping(value = "/createMeasurementGoal", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> createMeasurementGoal(
	//			@RequestBody DTOMeasurementGoal dtoMeasurementGoal) {
	//
	//		if (dtoMeasurementGoal.getQuestionsRef() == null
	//				|| dtoMeasurementGoal.getMetricsRef() == null)
	//			return measurementGoalService.createMeasurementGoal(
	//					dtoMeasurementGoal.getMeasurementGoalId(),
	//					dtoMeasurementGoal.getObject(),
	//					dtoMeasurementGoal.getPurpose(),
	//					dtoMeasurementGoal.getQualityFocus(),
	//					dtoMeasurementGoal.getViewpoint(),
	//					dtoMeasurementGoal.getContext(),
	//					dtoMeasurementGoal.getCreationDate(),
	//					dtoMeasurementGoal.getLastModified(),
	//					dtoMeasurementGoal.getInterpretationModel(),
	//					dtoMeasurementGoal.getVersion());
	//
	//		else
	//			return measurementGoalService.createMeasurementGoal(
	//					dtoMeasurementGoal.getMeasurementGoalId(),
	//					dtoMeasurementGoal.getObject(),
	//					dtoMeasurementGoal.getPurpose(),
	//					dtoMeasurementGoal.getQualityFocus(),
	//					dtoMeasurementGoal.getViewpoint(),
	//					dtoMeasurementGoal.getContext(),
	//					dtoMeasurementGoal.getCreationDate(),
	//					dtoMeasurementGoal.getLastModified(),
	//					dtoMeasurementGoal.getInterpretationModel(),
	//					dtoMeasurementGoal.getVersion(),
	//					dtoMeasurementGoal.getQuestionsRef(),
	//					dtoMeasurementGoal.getMetricsRef());
	//	}

	//	@RequestMapping(value = "/deleteMeasurementGoal", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> deleteMeasurementGoal(
	//			@RequestBody DTOMeasurementGoal dtoMeasurementGoal) {
	//
	//		return measurementGoalService.deleteMeasurementGoal(dtoMeasurementGoal
	//				.getMeasurementGoalId());
	//
	//	}

	//	@RequestMapping(value = "/deleteAllMeasurementGoal", method = RequestMethod.GET)
	//	public ResponseEntity<DTOresponse> deleteAllMeasurementGoal() {
	//
	//		return measurementGoalService.deleteAllMeasurementGoal();
	//
	//	}
	//
	//	@RequestMapping(value = "/getStrategies", method = RequestMethod.GET)
	//	public ResponseEntity<DTOresponse> getStrategies() {
	//		return strategyService.getStrategies();
	//	}

	//	@RequestMapping(value = "/createStrategy", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> createStrategy(
	//			@RequestBody DTOStrategy dtoStrategy) {
	//		
	//		if(dtoStrategy.getGoalRef()==null)
	//			return strategyService.createStrategy(dtoStrategy.getStrategyId(),dtoStrategy.getStrategyName(),
	//					dtoStrategy.getContext(), dtoStrategy.getAssumptions(),
	//					dtoStrategy.getDescription(), dtoStrategy.getCreationDate(),
	//					dtoStrategy.getLastModified(), dtoStrategy.getTimeFrame(),
	//					dtoStrategy.getVersion() );
	//		else			
	//			return strategyService.createStrategy(dtoStrategy.getStrategyId(),dtoStrategy.getStrategyName(),
	//					dtoStrategy.getContext(), dtoStrategy.getAssumptions(),
	//					dtoStrategy.getDescription(), dtoStrategy.getCreationDate(),
	//					dtoStrategy.getLastModified(), dtoStrategy.getTimeFrame(),
	//					dtoStrategy.getVersion(), dtoStrategy.getGoalRef());
	//	}

	//	@RequestMapping(value = "/deleteStrategy", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> deleteStrategy(
	//			@RequestBody DTOStrategy dtoStrategy) {
	//
	//		return strategyService.deleteStrategy(dtoStrategy.getStrategyId());
	//
	//	}

	//	@RequestMapping(value = "/createGoal", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> createGoal(@RequestBody DTOGoal dtoGoal) {
	//
	//		if (dtoGoal.getMeasurementRef() == null
	//				|| dtoGoal.getStrategyRef() == null)
	//			return goalService.createGoal(dtoGoal.getGoalId(),dtoGoal.getGoalName(),
	//					dtoGoal.getVersion(), dtoGoal.getCreationDate(),
	//					dtoGoal.getLastModified(), dtoGoal.getTimeFrame(),
	//					dtoGoal.getObject(), dtoGoal.getMagnitude(),
	//					dtoGoal.getFocus(), dtoGoal.getCostraint(),
	//					dtoGoal.getOrganizationalScope(), dtoGoal.getDescription());
	//		else
	//			return goalService.createGoal(dtoGoal.getGoalId(),dtoGoal.getGoalName(),
	//					dtoGoal.getVersion(), dtoGoal.getCreationDate(),
	//					dtoGoal.getLastModified(), dtoGoal.getTimeFrame(),
	//					dtoGoal.getObject(), dtoGoal.getMagnitude(),
	//					dtoGoal.getFocus(), dtoGoal.getCostraint(),
	//					dtoGoal.getOrganizationalScope(), dtoGoal.getDescription(),
	//					dtoGoal.getMeasurementRef(), dtoGoal.getStrategyRef());
	//
	//	}

	//	@RequestMapping(value = "/getGoals", method = RequestMethod.GET)
	//	public ResponseEntity<DTOresponse> getGoals() {
	//		return goalService.getGoals();
	//	}

	//	@RequestMapping(value = "/deleteGoal", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> deleteGoal(@RequestBody DTOGoal dtoGoal) {
	//
	//		return goalService.deleteGoal(dtoGoal.getGoalId());
	//
	//	}
	//
	//	@RequestMapping(value = "/deleteAllGoal", method = RequestMethod.GET)
	//	public ResponseEntity<DTOresponse> deleteAllGoal() {
	//
	//		return goalService.deleteAllGoal();
	//
	//	}

	//	@RequestMapping(value = "/createStatus", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> createStatus(
	//			@RequestBody DTOStatus dtoStatus) {
	//
	//		return statusService.createStatus(dtoStatus.getStatusId(),
	//				dtoStatus.getStatus(), dtoStatus.getCreationDate(),
	//				dtoStatus.getLastModified(), dtoStatus.getGoalRef(), dtoStatus.getProjectRef());
	//
	//	}

	@RequestMapping(value = "/getStatus", method = RequestMethod.GET)
	public ResponseEntity<DTOresponse> getStatus() {
		return statusService.getStatus();
	}

	//	@RequestMapping(value = "/deleteStatus", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> deleteStatus(
	//			@RequestBody DTOStatus dtoStatus) {
	//
	//		return statusService.deleteStatus(dtoStatus.getStatusId());
	//
	//	}
	//	@RequestMapping(value = "/getStatusByProjectId/{projectRef}", method = RequestMethod.GET)
	//	public ResponseEntity<DTOresponse> getStatusByProjectId(@PathVariable(value="projectRef")final String projectRef ) {
	//		return statusService.getStatusByProjectId(projectRef);
	//	}
	//
	//
	//	@RequestMapping(value = "/deleteAllStatus", method = RequestMethod.GET)
	//	public ResponseEntity<DTOresponse> deleteAllStatus() {
	//
	//		return statusService.deleteAllStatus();
	//
	//	}

	//	@RequestMapping(value = "/createProject", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> createProject(
	//			@RequestBody DTOProject dtoProject) {
	//
	//		return projectService.createProject(dtoProject.getProjectID(),
	//				dtoProject.getName(), dtoProject.getCreationDate(),
	//				dtoProject.getDescription(), dtoProject.getVersion(),
	//				dtoProject.getgoalRef());
	//
	//	}

	@RequestMapping(value = "/getProject", method = RequestMethod.GET)
	public ResponseEntity<DTOresponse> getproject() {
		return projectService.getProject();
	}

	//	@RequestMapping(value = "/deleteProject", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> deleteProject(
	//			@RequestBody DTOProject dtoProject) {
	//
	//		return projectService.deleteProject(dtoProject.getProjectID());
	//
	//	}
	//
	//	@RequestMapping(value = "/deleteAllProject", method = RequestMethod.GET)
	//	public ResponseEntity<DTOresponse> deleteAllProject() {
	//
	//		return projectService.deleteAllProject();
	//
	//	}

	@RequestMapping(value = "/getRetrospectiveReports", method = RequestMethod.GET)
	public ResponseEntity<DTOresponse> getRetrospectiveReports() {
		return retrospectiveReportService.getRetrospectiveReports();
	}

	//	@RequestMapping(value = "/createRetrospectiveReport", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> createRetrospectiveReport(@RequestBody DTORetrospectiveReport dtoReport) {
	//
	//		return retrospectiveReportService.createRetrospectiveReport(dtoReport.getRetrospectiveReportId(),
	//				dtoReport.getConclusion(), dtoReport.getLastModified(), dtoReport.getIds(),
	//				dtoReport.getPriorityList(),dtoReport.getDescriptionList());
	//	}
	//	@RequestMapping(value = "/deleteRetrospectiveReport", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> deleteRetrospectiveReport(@RequestBody DTORetrospectiveReport dtoReport) {
	//
	//		return retrospectiveReportService.deleteRetrospectiveReport(dtoReport.getRetrospectiveReportId());
	//
	//	}
	//
	//	@RequestMapping(value = "/deleteAllRetrospectiveReports", method = RequestMethod.GET)
	//	public ResponseEntity<DTOresponse> deleteAllRetrospectiveReport() {
	//
	//		return retrospectiveReportService.deleteAllRetrospectiveReport();
	//
	//	}

	//	@RequestMapping(value = "/sendBusMessage", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> sendBusMessage(@RequestBody DTOBus dtoBus) {
	//		ResponseEntity<DTOresponse> temp=null;
	//		try {
	//			System.out.println("metricService.getMetrics().getBody().toString(): "+ metricService.getMetrics().getBody().getMetrics());
	//			
	//			temp = busService.createBusEntity("Project1","TestFase5","project");
	//		} catch (JSONException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}		
	//		return busService.sendBusMessage(dtoBus.getTag(),dtoBus.getContent(),dtoBus.getTypeObject(),dtoBus.getOriginAddress(),dtoBus.getResolveAddress(),dtoBus.getId());
	//	}

	//	@RequestMapping(value = "/receiveBusMessage", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> receiveBusMessage(@RequestBody DTOBus dtoBus) {
	//		ResponseEntity<DTOresponse> temp=null;
	//		try {
	//			temp = busService.receiveBusMessage(dtoBus.getTag(), dtoBus.getTypeObject());
	//		} catch (JSONException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}		
	//		//System.out.println("temp: ->"+temp.getBody().getMessage());
	//		//temp.getBody().getMessage();
	//		
	//		return busService.receiveBusMessage(dtoBus.getTypeObject());//se fallisce la chiamata al bus
	//	}


	//	@RequestMapping(value = "/queryTagMessage", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> queryTagMessage(@RequestBody DTOBus dtoBus) {
	//
	//		return busService.queryTagMessage(dtoBus.getTag());
	//	}
	//	@RequestMapping(value = "/queryTagAndTypeMessage", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> queryTagAndTypeMessage(@RequestBody DTOBus dtoBus) {
	//
	//		return busService.queryTagAndTypeMessage(dtoBus.getTag(),dtoBus.getTypeObject());
	//	}


	//	@RequestMapping(value = "/createValidateData", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> createValidateData(
	//			@RequestBody DTOValidateData dtoValidateData) {
	//		
	//		return validateDataService.createValidateData(dtoValidateData.getDataId(),dtoValidateData.getData(),dtoValidateData.getBusinessWorkflowInstanceId(),dtoValidateData.getStrategyRef(),dtoValidateData.getMetricRef());
	//
	//	}

	@RequestMapping(value = "/getValidateData", method = RequestMethod.GET)
	public ResponseEntity<DTOresponse> getValidateData() {
		return validateDataService.getValidateData();
	}

	//	@RequestMapping(value = "/deleteAllBusMessage", method = RequestMethod.GET)
	//	public ResponseEntity<DTOresponse> deleteAllBusMessage() {
	//
	//		return busService.deleteAllBusMessage();
	//
	//	}
	//
	//	@RequestMapping(value = "/createScheduleChart", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> createScheduleChart(
	//			@RequestBody DTOScheduleChart dtoScheduleChart) {
	//
	//		return scheduleChartService.createScheduleChart(dtoScheduleChart.getScheduleId(),dtoScheduleChart.getFase(),dtoScheduleChart.getStartDate(),dtoScheduleChart.getLastDate());
	//
	//	}

	@RequestMapping(value = "/getScheduleChart", method = RequestMethod.GET)
	public ResponseEntity<DTOresponse> getScheduleChart() {
		return scheduleChartService.getScheduleChart();
	}

	//	@RequestMapping(value = "/deleteAllScheduleChart", method = RequestMethod.GET)
	//	public ResponseEntity<DTOresponse> deleteAllScheduleChart() {
	//
	//		return scheduleChartService.deleteAllScheduleChart();
	//
	//	}
	//	@RequestMapping(value = "/deleteScheduleChart", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> deleteScheduleChart(@RequestBody DTOScheduleChart dtoScheduleChart) {
	//
	//		return scheduleChartService.deleteScheduleChart(dtoScheduleChart.getScheduleId());
	//
	//	}

	//	@RequestMapping(value = "/createSendingOutComeFase6", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> createSendingOutComeFase6(
	//			@RequestBody DTOSendingOutComesFase6 dtoSendingOutComesFase6) {
	//
	//		return sendingOutComesFase6Service.createSendingOutComeFase6(dtoSendingOutComesFase6.getFileId(),dtoSendingOutComesFase6.getReport());
	//
	//	}
	//	@RequestMapping(value = "/getSendingOutComeFase6", method = RequestMethod.GET)
	//	public ResponseEntity<DTOresponse> getSendingOutComeFase6() {
	//		return sendingOutComesFase6Service.getSendingOutComeFase6();
	//	}
	//	
	//	@RequestMapping(value = "/deleteAllSendingOutComeFase6", method = RequestMethod.POST)
	//	public ResponseEntity<DTOresponse> deleteAllSendingOutComeFase6(@RequestBody DTOSendingOutComesFase6 dtoSendingOutComesFase6) {
	//
	//		return sendingOutComesFase6Service.deleteAllSendingOutComeFase6();
	//
	//	}

	@RequestMapping(value = "/createReport", method = RequestMethod.POST)
	public ResponseEntity<DTOresponse> createReport(@RequestBody String reportObject) throws JSONException {
		System.out.println("body to string: " + reportObject);
		return busService.createReport(reportObject);
	}

	@RequestMapping(value = "/getSendingOutcomes", method = RequestMethod.POST)
	public String getSendingOutcomes() throws JSONException, UnsupportedEncodingException {
		ResponseEntity<DTOresponse> parser = busService.getSendingOutcomes();
		JSONArray arr = new JSONArray(parser.getBody().getMessage());
		JSONObject obj = arr.getJSONObject(0);
		//System.out.println("obj" + obj);
		String objstr = obj.getString("payload").toString();
		//System.out.println("objstr: " + objstr);
		JSONObject pay = new JSONObject(objstr);
		//System.out.println("pay: " + pay);
		String project = pay.getString("project");
		//System.out.println("project: " + project);
		String status = pay.getString("status");
		//System.out.println("status: " + status);
		//		JSONObject test = new JSONObject();
		//		test.put("project", project);
		//		test.put("status", status);
		String feedback = pay.getString("feedback");
		String retrospectiveReportID = pay.getString("retrospectiveReportId");
		return "{ \"project\": " + project + ","+ "\"status\":"+ status + ","+"\"feedback\":" +feedback +","+"\"reportID\":"+"\""+retrospectiveReportID+"\"" + "}";
	}

	@RequestMapping(value = "/getChartData", method = RequestMethod.POST)
	public String getChartData() throws JSONException {
		ResponseEntity<DTOresponse> parser = busService.getChartData();
		JSONArray arr = new JSONArray(parser.getBody().getMessage());
		JSONObject obj = arr.getJSONObject(0);
		//System.out.println("obj" + obj);
		String objstr = obj.getString("payload").toString();
		//System.out.println("objstr: " + objstr);
		JSONArray pay = new JSONArray(objstr);
		//System.out.println("pay: " + pay);
		return pay.toString();
	}

	@RequestMapping(value = "/getScheduleChartData", method = RequestMethod.POST)
	public String getScheduleChartData() throws JSONException {
		ResponseEntity<DTOresponse> parser = busService.getScheduleChartData();
		JSONArray arr = new JSONArray(parser.getBody().getMessage());
		JSONObject obj = arr.getJSONObject(0);
		//System.out.println("obj" + obj);
		String objstr = obj.getString("payload").toString();
		//System.out.println("objstr: " + objstr);
		JSONArray pay = new JSONArray(objstr);
		//System.out.println("pay: " + pay);
		return pay.toString();
	}

	@RequestMapping(value = "/getUsersFromBus", method = RequestMethod.POST)
	public String getUsersFromBus() throws JSONException {
		ResponseEntity<DTOresponse> parser = busService.getUsersFromBus();
		JSONArray arr = new JSONArray(parser.getBody().getMessage());
		return arr.toString();

	}

	@RequestMapping(value ={"/grid","/outcomes","/scheduleChart","/charts"},  method = RequestMethod.GET)
	public String redirectHome() {
		return redirectProd;
	}

	@Override
	@RequestMapping(value ="/error",  method = RequestMethod.GET)
	public String getErrorPath() {
		return redirectProd;
	}

}
