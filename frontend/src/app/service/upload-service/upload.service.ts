import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  constructor(private http: HttpClient) { }
  upload(file: File): any{
    const formData: FormData = new FormData();
    formData.append('file', file);
    return this.http.post<Observable<HttpEvent<any>>>('http://192.168.130.197:8080/api/test/upload', formData,
      {responseType: 'json', reportProgress: true});
  }

  getFile(): any {

    return this.http.get<Observable<any>>('http://192.168.130.197:8080/api/test/files');
  }
}
