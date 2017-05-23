import { ActionReducer, Action } from '@ngrx/store';
import { StatusActions } from '../actions/status.actions';

let initialState: any = []

export const statusReducer: ActionReducer<any> = (state: any = initialState, action: Action) => {
  switch (action.type) {
    case StatusActions.ADD_STATUS:
      return action.payload;
    case StatusActions.CLEAN:
      return initialState;
    default:
      return state;
  }
};
