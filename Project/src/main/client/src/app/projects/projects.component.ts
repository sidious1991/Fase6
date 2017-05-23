import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { ProjectsService } from './projects.service';
import { Project } from '../models/project.model';

import { Router } from '@ngrx/router';

import { Store } from '@ngrx/store';
import { AppState } from '../appState';
import { OriginalActions } from '../actions/original.actions';
import { ProjectActions } from '../actions/project.actions';
import { StatusActions } from '../actions/status.actions';
import { ScheduleChartActions } from '../actions/scheduleChart.actions';
import { RetrospectiveReportActions } from '../actions/retrospectiveReport.actions';

@Component({
  moduleId: module.id,
  selector: 'projects-cmp',
  template: require('./projects.component.html'),
  styles: [require('./projects.component.css')],
  providers: [ProjectsService]
})
export class ProjectsComponent implements OnInit {

  projects: Object[] = [];
  outcomes: any = {
    project: {},
    status: [],
    feedback: [],
    reportID: []
  };
  feedbacks: any = [];
  
  constructor(
      private _projectsService: ProjectsService,
      private _router: Router,
      private _store: Store<AppState>
    ) {
      
  }

  ngOnInit() {
    this.getProjects();
  }

  getProjects() {
    this._projectsService.getProjects()
      .subscribe(
        res => {
          this.outcomes = res;
          if(this.outcomes.project.$$hashKey) {
            delete this.outcomes.project.$$hashKey;
          }
          this.projects.push(this.outcomes.project);
          let parsedStatus = [];
          this.outcomes.status.forEach(s => parsedStatus.push({
            statusId: s.statusId,
            status: s.status,
            goalId: s.goalRef.goalId,
            projectID: s.projectRef.projectID,
            feedback: s.feedback,
            reportID: s.reportID
          }))
          this.outcomes.status = parsedStatus;
        },
        error => console.log(error)
      );
  }

  getSchedule() {
    this._projectsService.getScheduleChartData()
      .subscribe(
        data => this._store.dispatch(ScheduleChartActions.add(data))
      );
  }

  addProject() {
    this._store.dispatch({type: 'CLEAN'});
    this.getSchedule();
    this._store.dispatch(OriginalActions.add(this.outcomes.project));
    this._store.dispatch(ProjectActions.add(this.outcomes.project));
    this._store.dispatch(StatusActions.add(this.outcomes.status));

    this.addFeedback()
    this._store.dispatch(RetrospectiveReportActions.add(this.feedbacks));
    this._router.go('/Fase6/grid');
  }

  addFeedback() : void {
    var k = 0;
    while(this.outcomes.feedback[k] != null){
      if(this.outcomes.reportID == this.outcomes.feedback[k].retrospectiveReportId){
        this.feedbacks.push(this.outcomes.feedback[k]);
      }
      k++;
    }
  }

}
