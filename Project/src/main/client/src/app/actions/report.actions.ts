import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';
import { Report } from '../models/report.model';

@Injectable()
export class ReportActions {

  static ADD_REPORT = 'ADD_REPORT';
  static add(report: Report): Action {
    return {
      type: ReportActions.ADD_REPORT,
      payload: report
    }
  }

  static LOAD_REPORT = 'LOAD_REPORT';
  static load(): Action {
    return {
      type: ReportActions.LOAD_REPORT
    };
  }

  static CLEAN = 'CLEAN';
  static clean(): Action {
    return {
      type: ReportActions.CLEAN
    }
  };
}
