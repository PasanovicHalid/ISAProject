import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse,
} from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { LoginUser } from '../model/login-user.model';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private apiServerUrl = 'http://localhost:8086/';
  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) {}

  login(loginUser: LoginUser): Observable<any> {
    console.log(loginUser);
    // this.headers.append('Access-Control-Allow-Origin', 'http://localhost:8086');
    // this.headers.append('Access-Control-Allow-Credentials', 'true');
    return this.http.post(this.apiServerUrl + 'authenticate', loginUser, {
      headers: this.headers,
      responseType: 'text',
    });
  }

  roleMatch(allowedRoles: string[]): boolean {
    var isMatch = false;
    var token = localStorage.getItem('token');
    if (token == null) token = '';
    var payLoad = JSON.parse(window.atob(token.split('.')[1]));
    console.log(payLoad);
    var userRole = payLoad.role.authority;
    console.log(userRole);
    allowedRoles.forEach((element) => {
      if (userRole == element) {
        isMatch = true;
      }
    });
    return isMatch;
  }
}
