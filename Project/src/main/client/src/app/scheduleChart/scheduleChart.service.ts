import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';
import { Project } from '../models/project.model';
import 'rxjs/Rx'

@Injectable()
export class ScheduleChartService {

  private _bridge = new Subject<Object>();
  private _ready = new Subject<Object>();

  chartData = this._bridge.asObservable();
  ready = this._ready.asObservable();

  constructor(private _http: Http) {
    
  }

  passChartData(data) {
    this._bridge.next(data);
  }

  readyToReceive(ok: boolean) {
    this._ready.next(ok);
  }

}
