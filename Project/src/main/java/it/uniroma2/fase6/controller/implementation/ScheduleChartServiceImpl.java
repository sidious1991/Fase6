package it.uniroma2.fase6.controller.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.uniroma2.fase6.controller.ScheduleChartService;
import it.uniroma2.fase6.model.ScheduleChart;
import it.uniroma2.fase6.model.rest.DTOresponse;
import it.uniroma2.fase6.repositories.ScheduleChartRepository;


@Service("ScheduleChartService")
public class ScheduleChartServiceImpl implements ScheduleChartService {

	@Autowired
	ScheduleChartRepository scheduleChartRepository;
	
	@Override
	public ResponseEntity<DTOresponse> createScheduleChart(String scheduleId,
			String fase, String startDate, String lastDate) {
		// TODO Auto-generated method stub
		ScheduleChart schedule = new ScheduleChart(scheduleId, fase, startDate, lastDate);
		scheduleChartRepository.save(schedule);
		DTOresponse dtoresponse = new DTOresponse();		
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse,HttpStatus.OK);
			
		return response;
	}

	@Override
	public ResponseEntity<DTOresponse> getScheduleChart() {
		// TODO Auto-generated method stub
		
		List<ScheduleChart> schedules = scheduleChartRepository.findAll();
		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setScheduleChart(schedules);

		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(
				dtoresponse, HttpStatus.OK);

		return response;
	}

	@Override
	public ResponseEntity<DTOresponse> deleteAllScheduleChart() {
		// TODO Auto-generated method stub
		scheduleChartRepository.delete(scheduleChartRepository.findAll());
		return null;
	}

	@Override
	public ResponseEntity<DTOresponse> deleteScheduleChart(String scheduleId) {
		// TODO Auto-generated method stub
		scheduleChartRepository.delete(scheduleChartRepository.findOne(scheduleId));

		return null;
	}

}
