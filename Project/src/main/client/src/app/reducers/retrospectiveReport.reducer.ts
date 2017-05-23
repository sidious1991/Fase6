import { ActionReducer, Action } from '@ngrx/store';
import { RetrospectiveReportActions } from '../actions/retrospectiveReport.actions';
import { RetrospectiveReport } from '../models/retrospectiveReport.model';

let initialState: RetrospectiveReport = {
  retrospectiveReportId: '',
	conclusion: '',
	lastModified: '',
	ids: [],
	priorityList: [],
	descriptionList: [],
}

export const retrospectiveReportReducer: ActionReducer<RetrospectiveReport> = (state: RetrospectiveReport = initialState, action: Action) => {
  switch (action.type) {
    case RetrospectiveReportActions.ADD_FEEDBACK:
      return Object.assign({}, action.payload);
    case RetrospectiveReportActions.LOAD_FEEDBACK:
      return state;
    case RetrospectiveReportActions.CLEAN:
      return Object.assign({}, initialState);
    default:
     return state;
  }
};