import { Project } from './models/project.model';
import { ScheduleChart } from './models/scheduleChart.model';
import { Report } from './models/report.model';
import { RetrospectiveReport } from './models/retrospectiveReport.model';

export interface AppState {
  original: Project;
  project: Project;
  changes: Object[];
  scheduleChart : ScheduleChart;
  report: Report;
  retrospectiveReport: RetrospectiveReport[];
}
