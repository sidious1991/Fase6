import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx'

@Injectable()
export class OutcomesService {

  private _outcomesUrl = 'createReport';

  constructor(private _http: Http) {

  }

  postOutcomes(planOut: any) {
    return this._http.post(this._outcomesUrl, planOut)
      .map((res: Response) => <Object> res.json());
  }

}