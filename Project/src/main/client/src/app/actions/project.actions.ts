import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';
import { Project } from '../models/project.model';

@Injectable()
export class ProjectActions {

  static ADD_PROJECT = 'ADD_PROJECT';
  static add(project: Project): Action {
    return {
      type: ProjectActions.ADD_PROJECT,
      payload: project
    }
  }

  static CLEAN = 'CLEAN';
  static clean(): Action {
    return {
      type: ProjectActions.CLEAN
    }
  };

}
