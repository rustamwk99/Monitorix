import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import { catchError, map, tap} from 'rxjs/operators';
import {User} from '../model/user';
import {DeployService} from '../service/deploy-service/deploy.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  user = new User();
  constructor(private http: HttpClient, private deployService: DeployService, private router: Router) {
  }
  // tslint:disable-next-line:typedef
  ngOnInit() {
    const baseUrl = this.deployService.url;
    const url = baseUrl + '/api/user';
    const headers: HttpHeaders = new HttpHeaders({
      Authorization: 'Basic ' + sessionStorage.getItem('token')

    });

    const options = { headers };
    // tslint:disable-next-line:ban-types
    this.http.post<Observable<User>>(url, {}, options).
    subscribe(principal => {
        this.user.login = sessionStorage.getItem('login');
      },
      error => {
        // tslint:disable-next-line:triple-equals
        if (error.status == 401){
          alert('Unauthorized');
          this.user.login = 'Unauthorized user';
          this.router.navigate(['/login']);
        }
      }
    );
  }

  // tslint:disable-next-line:typedef
  logout() {
    sessionStorage.setItem('token', '');
  }
  // tslint:disable-next-line:typedef
  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    return throwError(
      'Something bad happened; please try again later.');
  }
}
