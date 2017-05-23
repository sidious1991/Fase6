import { ActionReducer, Action } from '@ngrx/store';
import { OriginalActions } from '../actions/original.actions';
import { Project } from '../models/project.model';

let initialState: Project = {
  projectID : '',
  name : '',
  creationDate : '',
  description : '',
  version : '',
  goalRef : []
}

export const originalReducer: ActionReducer<Project> = (state: Project = initialState, action: Action) => {
  switch (action.type) {
    case OriginalActions.ADD_PROJECT:
      return Object.assign({}, action.payload);
    case OriginalActions.CLEAN:
      return Object.assign({}, initialState);
    default:
      return state;
  }
};
