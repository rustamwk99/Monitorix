import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DeployService} from '../deploy-service/deploy.service';

@Injectable({
  providedIn: 'root'
})
export class DownloadService {

  constructor(private http: HttpClient, private deployService: DeployService) { }

  downloadFile(): any {
    const baseUrl = this.deployService.url;
    const url = baseUrl + '/api/test/download';
    return this.http.get(url, {responseType: 'blob'});
  }
}
