import { ActionReducer, Action } from '@ngrx/store';
import { ChangesActions } from '../actions/changes.actions';

let initialState = {
  add: [],
  mod: [],
  del: []
};

export const changesReducer: ActionReducer<Object> = (state = initialState, action: Action) => {
  switch (action.type) {
    case ChangesActions.ADD_CHANGE:
    // TODO check for the same object
      let addState = Object.assign({}, state);
      addState.add.push(action.payload);
      return addState;
    case ChangesActions.MOD_CHANGE:
      let modState = Object.assign({}, state);
      modState.mod.push(action.payload);
      return modState;
    case ChangesActions.DEL_CHANGE:
      let delState = Object.assign({}, state);
      delState.del.push(action.payload);
      return delState;
    case ChangesActions.CLEAN:
      return initialState;
    default:
      return state;
  }
};
