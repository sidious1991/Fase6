import { Component, OnInit, OnDestroy, ChangeDetectionStrategy } from '@angular/core';

import { NgForm } from '@angular/common';

import { Observable } from 'rxjs/Observable';
import { Project } from '../models/project.model';
import { Status } from '../models/status.model';

import { Store } from '@ngrx/store';
import { AppState } from '../appState';
import { ProjectActions } from '../actions/project.actions';
import { ChangesActions } from '../actions/changes.actions';

import { TreeComponent } from './tree/tree.component';
import { GridEventsService } from './gridEvents.service';
import { TreePipe } from './tree/tree.pipe';

import { AppUtilService } from '../appUtil.service';

import { 
  Goal,
  MeasurementGoal,
  Strategy,
  Question,
  Metric
} from './tree/elementsTemplates';

@Component({
  moduleId: module.id,
  selector: 'grid-cmp',
  template: require('./grid.component.html'),
  directives: [TreeComponent],
  providers: [GridEventsService],
  pipes: [TreePipe],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class GridComponent implements OnInit, OnDestroy {

  status = [];
  project: Project;
  element: Object;
  addTemplate = {
    parentId: '',
    type: '',
    template: {}
  };
  delElement: any = {};

  constructor(
    private _store: Store<AppState>,
    private _eventService: GridEventsService,
    private _utilService: AppUtilService
  )
  {
    _store.select<Project>('project').subscribe(
      project => this.project = project
    );
    _store.select<any>('status').subscribe(
      status => this.status = status
    );
    this._eventService.modElement.subscribe(next => this.element = next);
    this._eventService.addElement.subscribe(next => this.addTemplate = next);
    this._eventService.delElement.subscribe(next => this.delElement = next);
  }
  
  ngOnInit() {
    this.getProject();
  }

  ngOnDestroy() {
    // this._store.unsubscribe();
    // this._eventService.addElement.unsubscribe();
    // this._eventService.modElement.unsubscribe();
    // this._eventService.delElement.unsubscribe();
  }

  getProject() {
    return this.project;
  }

  isObjectArray(obj): boolean {
    return this._utilService.isObjectArray(obj);
  }

  printDelTitle() {
    return this._utilService.printTitle(this.delElement);
  }

  planModify(form: Object): void {
    let projMod: Project = this.project;
    let change: Object = {};
    
    Object.keys(form).
      filter(key => {
        if( typeof this.element[key] === "number" ) {
          return ( (!(form[key] === "" && this.element[key] === null)) && form[key] !== JSON.stringify(this.element[key]) ); 
        }
        return ( (!(form[key] === "" && this.element[key] === null)) && form[key] !== this.element[key] );
      }).
      map(key => {
        this.element[key] = form[key];
        change[key] = form[key];
      });

    let id = this.modifyProject(projMod, this.element);
    let mod = {
      id: id,
      type: this._utilService.whatAmI(this.element),
      element: Object.assign(change, {id: id})
    };
    this._store.dispatch(ChangesActions.mod(mod));
    this._store.dispatch(ProjectActions.add(projMod));
  }

  planAdd(form: Object) {
    let projMod: Project = this.project;
    let change: Object = {};
    
    Object.keys(form).
      map(key => change[key] = form[key]);
    
    let mod = {
      type: this.addTemplate.type,
      id: this.addTemplate.parentId,
      element: change
    };

    this.addToProject(projMod, this.addTemplate.parentId, this.addTemplate.type, change);
    this._store.dispatch(ChangesActions.add(mod));
    this._store.dispatch(ProjectActions.add(projMod));

  }

  planDelete() {
    let projMod: Project = this.project;
    let mod = {
      type: this._utilService.whatAmI(this.delElement),
      // element: this.delElement,
      id: this.delElement.projectID || this.delElement.goalId || this.delElement.measurementGoalId || this.delElement.questionId || this.delElement.metricId || this.delElement.strategyId
    };
    this.deleteFromProject(projMod, this.delElement);
    this._store.dispatch(ChangesActions.del(mod));
    this._store.dispatch(ProjectActions.add(projMod));
  }

  modifyProject(project, sub) {
    let gridCmp = this;
    let found = false;
    let id = sub.projectID || sub.goalId || sub.measurementGoalId || sub.questionId || sub.metricId || sub.strategyId;
    Object.keys(project).forEach(function(k) {
      if(project[k] === id) {
        Object.assign(project, sub);
        found = true;
        return;
      }
      else if(!found && gridCmp.isObjectArray(project[k])) {
        project[k].forEach(function(e){
          gridCmp.modifyProject(e, sub);
        });
      }
    });
    return id;
  }

  addToProject(project, id, type, element): void {
    let gridCmp = this;
    Object.keys(project).forEach(function(k) {
      if(gridCmp.isObjectArray(project[k])) {
        project[k].forEach(function(e){
          gridCmp.addToProject(e, id, type, element);
        });
      }
      if(project[k] === id) {
        switch (type) {
          case Goal:
            if(!project.goalRef || project.goalRef === null) {
              project.goalRef = [];
            }
            project.goalRef.push(element);
            return;
          case Strategy:
            if(!project.strategyRef || project.strategyRef === null) {
              project.strategyRef = [];
            }
            project.strategyRef.push(element);
            return;
          case MeasurementGoal:
            if(!project.measurementRef || project.measurementRef === null) {
              project.measurementRef = [];
            }
            project.measurementRef.push(element);
            return;
          case Metric:
            if(!project.metricsRef || project.metricsRef === null) {
              project.metricsRef = [];
            }
            project.metricsRef.push(element);
            return;
          case Question:
            if(!project.questionsRef || project.questionsRef === null) {
              project.questionsRef = [];
            }
            project.questionsRef.push(element);
            return;
          default:
            // throw an error
            return;
        }
      }
    });
  }

  deleteFromProject(project, element) {
    let gridCmp = this;
    let id = element.projectID || element.goalId || element.measurementGoalId || element.questionId || element.metricId || element.strategyId;
    Object.keys(project).forEach(function(k) {
      if(gridCmp._utilService.isObjectArray(project[k])) {
        project[k] = project[k].filter(function(obj) {
          let objId = obj.projectID || obj.goalId || obj.measurementGoalId || obj.questionId || obj.metricId || obj.strategyId;
          return objId !== id;
        });
        project[k].forEach(function(e){
          gridCmp.deleteFromProject(e, element);
        });
      }
    });
  }

}
