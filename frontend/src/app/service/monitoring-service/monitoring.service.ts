import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DeployService} from '../deploy-service/deploy.service';

@Injectable({
  providedIn: 'root'
})
export class MonitoringService {

  constructor(private http: HttpClient, private deployService: DeployService) {
    }

    getLogs(): Observable<any> {
      const baseUrl = this.deployService.url;
      const url = baseUrl + '/api/monitoring';
      return this.http.get(url);
    }
  }

