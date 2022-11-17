import { Injectable } from '@angular/core';
import {
  HttpHeaders,
  HttpClient,
  HttpErrorResponse,
} from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { User } from 'src/app/model/Users/user';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  apiHost: string = 'http://localhost:8086/';
  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) {}
  //change customer: any to customer: Customer later
  registerCustomer(customer: any): Observable<any> {
    return this.http
      .post<any>(this.apiHost + 'api/customer/register', customer, {
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
