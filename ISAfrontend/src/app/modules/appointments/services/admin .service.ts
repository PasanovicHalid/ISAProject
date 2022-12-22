import { Injectable } from '@angular/core';
import {
  HttpHeaders,
  HttpClient,
  HttpErrorResponse,
  HttpParams,
} from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { BloodBankAdmin } from '../model/blood-bank-admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  apiHost: string = 'http://localhost:8086/';
  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  getBloodBankOfAdmin(id: string): Observable<BloodBankAdmin>{
    var httpParams = new HttpParams()
      .set('id', id)
    return this.http.get<any>(this.apiHost + 'api/admin/bank', {headers: this.headers, params: httpParams}).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    return throwError(() => new Error(error.status + '\n' + error.error));
  }
}
