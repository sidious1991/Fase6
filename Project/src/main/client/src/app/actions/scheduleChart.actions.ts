import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';
import { ScheduleChart } from '../models/scheduleChart.model';

@Injectable()
export class ScheduleChartActions {

  static ADD_SCHEDULECHART = 'ADD_SCHEDULECHART';
  static add(scheduleChart: ScheduleChart[]): Action {
    return {
      type: ScheduleChartActions.ADD_SCHEDULECHART,
      payload: scheduleChart
    }
  }
  
  static CLEAN = 'CLEAN';
  static clean(): Action {
    return {
      type: ScheduleChartActions.CLEAN
    }
  };

}
