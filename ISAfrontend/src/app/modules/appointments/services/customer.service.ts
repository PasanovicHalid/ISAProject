import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { User } from '../../user/edit-user/model/user';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  apiHost: string = 'http://localhost:8086/';
  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });
  constructor(private http: HttpClient) {}

  updateCustomer(customer: any): Observable<any> {
    return this.http
      .put<any>(this.apiHost + 'api/customer', customer, {
        headers: this.headers,
      })
      .pipe(catchError(this.handleValidationError));
  }

  getAllCustomers(): Observable<User[]> {
    return this.http
      .get<User[]>(this.apiHost + 'api/customer', { headers: this.headers })
      .pipe(catchError(this.handleValidationError));
  }

  getCustomerByID(id: any): Observable<User> {
    return this.http
      .get<User>(this.apiHost + 'api/customer/' + id, { headers: this.headers })
      .pipe(catchError(this.handleValidationError));
  }

  private handleValidationError(error: HttpErrorResponse) {
    return throwError(() => new Error(error.status + '\n' + error.error));
  }
}
