import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';

@Injectable()
export class ChangesActions {

  static ADD_CHANGE = 'ADD_CHANGE';
  static add(change): Action {
    return {
      type: ChangesActions.ADD_CHANGE,
      payload: change
    }
  }

  static MOD_CHANGE = 'MOD_CHANGE';
  static mod(change): Action {
    return {
      type: ChangesActions.MOD_CHANGE,
      payload: change
    }
  }

  static DEL_CHANGE = 'DEL_CHANGE';
  static del(change): Action {
    return {
      type: ChangesActions.DEL_CHANGE,
      payload: change
    }
  }

  static CLEAN = 'CLEAN';
  static clean(): Action {
    return {
      type: ChangesActions.CLEAN
    }
  };

}
