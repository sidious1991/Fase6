import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';

@Injectable()
export class StatusActions {

  static ADD_STATUS = 'ADD_STATUS';
  static add(status: any): Action {
    return {
      type: StatusActions.ADD_STATUS,
      payload: status
    }
  }

  static CLEAN = 'CLEAN';
  static clean(): Action {
    return {
      type: StatusActions.CLEAN
    }
  };

}
