import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Project } from '../models/project.model';
import 'rxjs/Rx';

import { ScheduleChart } from '../models/scheduleChart.model';

@Injectable()
export class ProjectsService {

  private _projectsUrl = 'getSendingOutcomes';

  private _chartsDataUrl = 'getScheduleChartData';

  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });
  
  constructor(private _http: Http) {

  }

  getProjects(): Observable<Object> {
    return this._http.post(this._projectsUrl, {}, this.options)
      .map((res: Response) => <Object> res.json());
  }

  getScheduleChartData(): Observable<ScheduleChart[]> {
    return this._http.post(this._chartsDataUrl, {})
      .map(res => res.json());
  }

}
