import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';

@Injectable()
export class AppService {

  private _usersUrl = 'getUsersFromBus';

  constructor(private _http: Http) {

  }

  getUsers() {
    return this._http.post(this._usersUrl, {})
      .map((res: Response) => <any[]> res.json());
  }

}
