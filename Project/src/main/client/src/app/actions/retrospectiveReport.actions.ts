import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';
import { RetrospectiveReport } from '../models/retrospectiveReport.model';

@Injectable()
export class RetrospectiveReportActions {

  static ADD_FEEDBACK = 'ADD_FEEDBACK';
  static add(retrospectiveReport: RetrospectiveReport): Action {
    return {
      type: RetrospectiveReportActions.ADD_FEEDBACK,
      payload: retrospectiveReport
    }
  }

  static LOAD_FEEDBACK = 'LOAD_FEEDBACK';
  static load(): Action {
    return {
      type: RetrospectiveReportActions.LOAD_FEEDBACK
    };
  }

  static CLEAN = 'CLEAN';
  static remove(): Action {
    return {
      type: RetrospectiveReportActions.CLEAN
    }
  };
}