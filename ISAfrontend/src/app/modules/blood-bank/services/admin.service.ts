import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http'
import { Observable, catchError, throwError } from 'rxjs';
import { Admin } from '../../../model/Users/admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  apiHost: string = "http://localhost:8086/";
  headers: HttpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private http: HttpClient) { }
  getBanklessAdmins(): Observable<Admin[]>{
    return this.http.get<Admin[]>(this.apiHost + 'api/admin', {headers: this.headers}).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    return throwError(() => new Error(error.status +'\n'+ error.error))
  }

}
