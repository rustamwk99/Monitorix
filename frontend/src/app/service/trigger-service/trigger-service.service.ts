import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DeployService} from '../deploy-service/deploy.service';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TriggerServiceService {

  constructor(private http: HttpClient, private deployService: DeployService) {
  }
  getTriggers(): Observable<any> {
    const baseUrl = this.deployService.url;
    const url = baseUrl + '/api/user_agent/triggers/';
    return this.http.get(`${url}`);
  }
  // tslint:disable-next-line:ban-types
  addTrigger(trigger: Object): Observable<Object> {
    const baseUrl = this.deployService.url;
    const url = baseUrl + '/api/user_agent/triggers/';
    return this.http.post(`${url}`, trigger);
  }

  deleteTrigger(id: bigint): Observable<any> {
    const baseUrl = this.deployService.url;
    const url = baseUrl + '/api/user_agent/triggers/';
    return this.http.delete(`${url}/${id}`, {responseType: 'text'});
  }
}
