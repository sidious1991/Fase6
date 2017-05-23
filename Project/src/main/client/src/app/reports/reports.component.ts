import { Component, Input, Output, EventEmitter } from '@angular/core';

import { Router } from '@ngrx/router';

import { Store } from '@ngrx/store';
import { AppState } from '../appState';
import { ReportActions } from '../actions/report.actions';

import { ChangesActions } from '../actions/changes.actions';

import { Project } from '../models/project.model';
import { ProjectsService } from '../projects/projects.service';

import { Report } from '../models/report.model';
import { ReportsService } from './reports.service';


@Component({
  moduleId: module.id,
  selector: 'reports-cmp',
  template: require('./reports.component.html'),
  styles: [require('./reports.component.css')],
  providers: [ReportsService , ProjectsService]
})

export class ReportsComponent {

  report : Report;
  project : Project;
  addReport : string = "";
  caricaReport : string = "";

  constructor(
    private _router: Router,
    private _store: Store<AppState>,
    private _reportService : ReportsService,
    private _projectService : ProjectsService
  ){
  
  
    _store.select<Report>('report')
    .subscribe(report => this.report = report);

    _store.select<Project>('project')
    .subscribe(project => this.project = project);
  }
    
  ngOnInit(){
    this.getProject();
    this.getReport();
    console.log(this.getReport());
    console.log(this.getProject());

    this.addReport = this.report.report
  }
  
  getReport(): Report {
    return this.report;
  }

  getProject() : Project {
    return this.project;
  }

  closeReport() :void {
    var obj = new ConfirmBox();
    if(obj.show() == true){
      this._router.go('/');
    } 
  }

  saveReport() : void {
   var Report = this.report;
   Report.report = this.addReport;
   //this.createReport();
   this._store.dispatch(ReportActions.add(Report));
   //console.log("Finito il salvataggio sullo store locale");

   //console.log("Sto salvando... " +Report.reportId + " " + Report.report + " " + Report.projectId);
   //this._reportService.saveReportToServer(Report)
   // .subscribe(
   //     response => console.log() ,
   //     error => console.log(error)
   //   )
   //console.log("Finito il salvataggio sul server!");
  }

  createReport(){
    // this.report.report = this.addReport;
    // this.report.projectId = this.project.projectID;
  }
}

class ConfirmBox
{
    show() : boolean {
       var c = window.confirm("Are you sure you want to do that?");
      if (c == true)    
           return true;
      else
        return false; 
    }
}
