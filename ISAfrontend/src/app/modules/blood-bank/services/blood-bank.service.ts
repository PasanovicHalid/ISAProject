import { Injectable } from '@angular/core';
import {
  HttpHeaders,
  HttpClient,
  HttpErrorResponse,
  HttpParams,
} from '@angular/common/http';
import { Observable, catchError, throwError, map } from 'rxjs';
import { BloodBank } from 'src/app/model/blood-bank.model';
import { PagableRequest } from '../model/pagable-request';

@Injectable({
  providedIn: 'root',
})
export class BloodBankService {
  apiHost: string = 'http://localhost:8086/';
  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  registerBloodBank(bloodBank: any): Observable<any> {
    return this.http
      .post<any>(this.apiHost + 'api/bloodbank', bloodBank, {
        headers: this.headers,
      })
      .pipe(catchError(this.handleError));
  }

  getBloodBanks(): Observable<any> {
    return this.http
      .get<BloodBank[]>(this.apiHost + 'api/bloodbank', {
        headers: this.headers,
      })
      .pipe(catchError(this.handleError));
  }

  getBloodBanksPagable(request: PagableRequest): Observable<BloodBank[]> {
    return this.http
      .put<BloodBank[]>(this.apiHost + 'api/bloodbank', request, {
        headers: this.headers,
      }).pipe(
        catchError(this.handleError),
      );
  }

  getAll(): Observable<BloodBank[]> {
    return this.http.get<BloodBank[]>(this.apiHost + 'api/bloodbank', { headers: this.headers }).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status == 406) {
      var map = new Map<string, string>();
      Object.keys(error.error).forEach(key => {
        map.set(key, error.error[key])
      });
      localStorage.setItem('errormap', JSON.stringify(Array.from(map.entries())));
    }

    return throwError(() => new Error(error.status + '\n' + error.error));
  }
}
