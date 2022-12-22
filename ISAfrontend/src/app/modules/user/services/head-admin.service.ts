import { Injectable } from '@angular/core';
import {
  HttpHeaders,
  HttpClient,
  HttpErrorResponse,
} from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { HeadAdmin } from '../model/head-admin.model';


@Injectable({
  providedIn: 'root'
})
export class HeadAdminService {

  apiHost: string = 'http://localhost:8086/';
  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) {}

  registerHeadAdmin(headAdmin: HeadAdmin): Observable<any> {
    return this.http
      .post<any>(this.apiHost + 'api/head_admin', headAdmin, {
        headers: this.headers,
      })
      .pipe(catchError(this.handleValidationError));
  }

  private handleValidationError(error: HttpErrorResponse) {
    var map = new Map<string, string>();
    Object.keys(error.error).forEach((key) => {
      map.set(key, error.error[key]);
    });
    localStorage.setItem('errormap', JSON.stringify(Array.from(map.entries())));

    return throwError(
      () => new Error(error.status + '\n' + error.error.message)
    );
  }
}
