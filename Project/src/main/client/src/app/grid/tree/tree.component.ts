import { Component, Input, Output, EventEmitter, OnInit, OnDestroy } from '@angular/core';
import { Project } from '../../models/project.model';
import { TreePipe } from './tree.pipe';
import { GridEventsService } from '../gridEvents.service';

import { AppUtilService } from '../../appUtil.service';

import { 
  Goal,
  GoalTemplate,
  MeasurementGoal,
  MeasurementGoalTemplate,
  Strategy, 
  StrategyTemplate,
  Question,
  QuestionTemplate,
  Metric, 
  MetricTemplate 
} from './elementsTemplates';

@Component({
  moduleId: module.id,
  selector: 'tree-cmp',
  template: require('./tree.component.html'),
  styles: [require('./tree.component.css')],
  pipes: [TreePipe],
  directives: [TreeComponent]
})
export class TreeComponent implements OnInit, OnDestroy {
  
  @Input('project') project: Project;

  @Input('status') status;

  private static _counter: number = 0;

  constructor(
    private _eventService: GridEventsService,
    private _utilService: AppUtilService
  ) {
    
  }

  ngOnInit() {
    
  }

  getStatus(goal) {
    let id = goal.goalId;
    let state = "";
    this.status.filter(sts => sts.goalId === id).forEach(sts => state = sts.status);
    if(state === "") {
      state = 'unchecked';
    }
    return state;
  }

  getStatusStyle(goal) {
    let id = goal.goalId;
    let state = "";
    this.status.filter(sts => sts.goalId === id).forEach(sts => state = sts.status);
    switch (state) {
      case 'accepted':
        return 'label label-success';
      case 'rejected':
        return 'label label-danger';
      case 'unchecked':
      default:
        return 'label label-default';
    }
  }

  private onModElement(element: Object) {
    this._eventService.emitElement(element);
  }

  private onAddElement(project, type: string) {
    let id = project.projectID || project.goalId || project.measurementGoalId || project.questionId || project.metricId || project.strategyId;
    let element: Object;
    switch (type) {
      case Goal:
        element = GoalTemplate;
        break;
      case Strategy:
        element = StrategyTemplate;
        break;
      case MeasurementGoal:
        element = MeasurementGoalTemplate;
        break;
      case Question:
        element = QuestionTemplate;
        break;
      case Metric:
        element = MetricTemplate;
        break;
      default:
        element = {};
        break;
    }
    this._eventService.emitTemplate({
      parentId: id,
      type: type,
      template: element
    });
  }

  onDeleteElement(project) {
    this._eventService.emitDelete(project);
  }

  ngOnDestroy() {
    TreeComponent._counter = 0;
  }

  isArray(obj): boolean {
    return this._utilService.isObjectArray(obj);
  }

  spawnId(): number {
    return ++TreeComponent._counter;
  }
  
  getId(): number {
    return TreeComponent._counter;
  }

  whatAmI(project): string {
    return this._utilService.whatAmI(project);
  }

}
