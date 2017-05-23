import { ActionReducer, Action } from '@ngrx/store';
import { ProjectActions } from '../actions/project.actions';
import { Project } from '../models/project.model';

let initialState: Project = {
  projectID : '',
  name : '',
  creationDate : '',
  description : '',
  version : '',
  goalRef : []
}

export const projectReducer: ActionReducer<Project> = (state: Project = initialState, action: Action) => {
  switch (action.type) {
    case ProjectActions.ADD_PROJECT:
      return Object.assign({}, action.payload);
    case ProjectActions.CLEAN:
      return Object.assign({}, initialState);
    default:
      return state;
  }
};
