import { ActionReducer, Action } from '@ngrx/store';
import { ScheduleChartActions } from '../actions/scheduleChart.actions';
import { ScheduleChart } from '../models/scheduleChart.model';

let initialState: ScheduleChart[] = [
{
    scheduleId : "",
    fase : "0",
    startDate: "",
    lastDate: "",
},
{
    scheduleId : "",
    fase : "1",
    startDate: "",
    lastDate: "",
},
{
    scheduleId : "",
    fase : "2",
    startDate: "",
    lastDate: "",
},
{
    scheduleId : "",
    fase : "3",
    startDate: "",
    lastDate: "",
},
{
    scheduleId : "",
    fase : "4",
    startDate: "",
    lastDate: "",
},
{
    scheduleId : "",
    fase : "5",
    startDate: "",
    lastDate: "",
},
{
    scheduleId : "",
    fase : "6",
    startDate: "",
    lastDate: "",
}
]

export const scheduleChartReducer: ActionReducer<ScheduleChart[]> = (state: ScheduleChart[] = initialState, action: Action) => {
  switch (action.type) {
    case ScheduleChartActions.ADD_SCHEDULECHART:
      return action.payload;
    case ScheduleChartActions.CLEAN:
      return initialState;
    default:
      return state;
  }
};
