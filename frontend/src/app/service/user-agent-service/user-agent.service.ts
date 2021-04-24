import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {System} from '../../model/system';
import {DeployService} from '../deploy-service/deploy.service';

@Injectable({
  providedIn: 'root'
})
export class UserAgentService {
  path: string;
  private baseUrl = '';
  url = this.baseUrl + '/api/user';
  constructor(private http: HttpClient, private deployService: DeployService) {
    this.path = '';
  }
  userAgent(): Observable<System> {
    this.baseUrl = this.deployService.url;
    this.url = this.baseUrl + '/api/user_agent';
    return this.http.post<System>(this.url, {});
  }

  downloadFile(): any {
    this.baseUrl = this.deployService.url;
    this.url = this.baseUrl + '/api/user_agent/download/';
    return this.http.get(this.url + this.path, {responseType: 'blob'});
  }
}
