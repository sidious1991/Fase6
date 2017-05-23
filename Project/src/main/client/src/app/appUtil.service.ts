import { Injectable } from '@angular/core';

@Injectable()
export class AppUtilService {

  constructor() { }

  isObjectArray(obj): boolean {
    if( obj instanceof Array && obj.length !== 0 && typeof obj[0] === "object" ) {
      return true;
    }
    return false;
  }

  whatAmI(project): string {
    if(project.projectID) {
      return "Project";
    }
    if(project.goalId) {
      return "Goal";
    }
    if(project.measurementGoalId) {
      return "MeasurementGoal";
    }
    if(project.questionId) {
      return "Question";
    }
    if(project.metricId) {
      return "Metric";
    }
    if(project.strategyId) {
      return "Strategy";
    }
    return "";
  }

  printTitle(project): string {
    if(project.projectID) {
      return "Project " + project.projectID;
    }
    if(project.goalId) {
      return "Goal " + project.goalId;
    }
    if(project.measurementGoalId) {
      return "Measurement Goal " + project.measurementGoalId;
    }
    if(project.questionId) {
      return "Question " + project.questionId;
    }
    if(project.metricId) {
      return "Metric " + project.metricId;
    }
    if(project.strategyId) {
      return "Strategy " + project.strategyId;
    }
    return "";
  }

}
