import { Injectable } from '@angular/core';
import { Http, Response , Headers, RequestOptions} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Report } from '../models/report.model';


import 'rxjs/Rx'

@Injectable()
export class ReportsService {

  private _reportUrl = 'getReports';
  private _saveReportUrl = 'createReport';

  constructor(private _http: Http) { 
  }

  getReport() : Observable<Report[]> {
    return this._http.get(this._reportUrl)
      .map((res: Response) => <Report[]> res.json().reports);
  }

  saveReportToServer(report : Report)  {
    //console.log(report); 
    //var ReportId = report.reportId;
    //var Report = report.report;
    var Report = report.report;
    //console.log("Invio dei dati...");

    //let body = JSON.stringify({ reportId: ReportId, report: Report, projectId: ProjectId });
    //console.log(body);
    //let headers = new Headers({ 'Content-Type': 'application/json' });
    //let options = new RequestOptions({ headers: headers });
    //return this._http.post(this._saveReportUrl,report,options);
  }
}

