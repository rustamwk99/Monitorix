import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {System} from '../model/system';
import {Observable} from 'rxjs';
import {DeployService} from './deploy-service/deploy.service';

@Injectable({
  providedIn: 'root'
})
export class TestService {
  private url: string;
  private testUrl: string;
  private baseUrl = '';

  constructor(private http: HttpClient, private deployService: DeployService) {
    //this.url = 'http://192.168.130.197:8080/api/test';
    this.baseUrl = this.deployService.url;
    this.url = this.baseUrl + '/api/test';
    this.testUrl = this.baseUrl + '/api/user_agent';
  }

  public findAll(): Observable<System> {
    return this.http.post<System>(this.url, {});
  }
  //тестовые
  public userAgent(): Observable<System> {
    return this.http.post<System>(this.testUrl, {});
  }
}
