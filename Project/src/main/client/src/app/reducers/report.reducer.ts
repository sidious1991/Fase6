import { ActionReducer, Action } from '@ngrx/store';
import { ReportActions } from '../actions/report.actions';
import { Report } from '../models/report.model';

let initialStateReport: Report = {
   // reportId : '',
    report : '',
   // projectId : ''
    
}

export const reportReducer: ActionReducer<Report> = (state: Report = initialStateReport, action: Action) => {
  switch (action.type) {
    case ReportActions.ADD_REPORT:
      return Object.assign({}, action.payload);
    case ReportActions.LOAD_REPORT:
      return state;
    case ReportActions.CLEAN:
      return Object.assign({}, initialStateReport);
    default:
     return state;
  }
};