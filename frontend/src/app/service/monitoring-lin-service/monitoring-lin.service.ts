import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DeployService} from '../deploy-service/deploy.service';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MonitoringLinService {

  constructor(private http: HttpClient, private deployService: DeployService) {
  }
  getLinLogs(): Observable<any> {
    const baseUrl = this.deployService.url;
    const url = baseUrl + '/api/monitoringLin';
    return this.http.get(url);
  }
}
