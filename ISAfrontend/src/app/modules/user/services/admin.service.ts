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

  // registerBloodBank(bloodBank: any): Observable<any>{
  //   return this.http.post<any>(this.apiHost + 'api/bloodbank', bloodBank, {headers: this.headers}).pipe(catchError(this.handleValidationError));
  // }
}
