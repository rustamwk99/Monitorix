import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {User} from '../model/user';
import {Observable} from 'rxjs';
import {DeployService} from '../service/deploy-service/deploy.service';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private router: Router,
              private http: HttpClient,
              private deployService: DeployService) { }
  user = new User();

  ngOnInit(): void {
  }
  // registration(){
  //
  //   this.http.get<Observable<User>>(url).subscribe(userForm =>
  //     this.user.login = User.name )
  // }
  save() {
    const baseUrl = this.deployService.url;
    const url = baseUrl + '/api/registration';
    this.http.post<Observable<boolean>>(url, {
      login: this.user.login,
      password: this.user.password,
      confirmPassword: this.user.confirmPassword
    }).subscribe(isValid => {
      if (isValid) {
        // sessionStorage.setItem('token', btoa(this.user.login + ':' + this.user.password));
        this.router.navigate(['login']);

      } else {
        alert('Authentication failed.');
      }
    });
  }

}
