import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';
import { Project } from '../models/project.model';
import 'rxjs/Rx'

@Injectable()
export class ChartsService {

  private _chartsDataUrl = 'getChartData';  

  private _bridge = new Subject<Object>();
  private _ready = new Subject<Object>();

  chartData = this._bridge.asObservable();
  ready = this._ready.asObservable();

  constructor(private _http: Http) {
    
  }

  getChartsData(): Observable<Object[]> {
    return this._http.post(this._chartsDataUrl, {})
      .map(res => res.json());
  }


  passChartData(data) {
    this._bridge.next(data);
  }

  readyToReceive(ok: boolean) {
    this._ready.next(ok);
  }

}
