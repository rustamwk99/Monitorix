import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DeployService {
  public url = 'http://localhost:8080';
  constructor() { }
  workingUrl(){
    return this.url;
  }
}
