import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import {User} from '../model/user';
import {DeployService} from '../service/deploy-service/deploy.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient,
    private deployService: DeployService
  ) { }
  user = new User();

  ngOnInit(): void {
    sessionStorage.setItem('token', '');
  }
  auth() {
    const baseUrl = this.deployService.url;
    const url = baseUrl + '/api/login';
    this.http.post<Observable<boolean>>(url, {
      login: this.user.login,
      password: this.user.password
    }).subscribe(isValid => {
      if (isValid) {
        sessionStorage.setItem('token', btoa(this.user.login + ':' + this.user.password));
        sessionStorage.setItem('login', this.user.login);
        this.router.navigate(['']);

      } else {
        alert('Authentication failed.');
      }
    });
  }


}
