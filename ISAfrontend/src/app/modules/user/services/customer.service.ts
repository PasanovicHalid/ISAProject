import { Injectable } from '@angular/core';
import {
  HttpHeaders,
  HttpClient,
  HttpErrorResponse,
} from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Customer } from 'src/app/model/Users/customer';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  public customer: Customer
  apiHost: string = 'http://localhost:8086/';
  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) {}
  //change customer: any to customer: Customer later
  registerCustomer(customer: any): Observable<any> {
    return this.http
      .post<any>(this.apiHost + 'registerNotActivated', customer, {
        headers: this.headers,
      })
      .pipe(catchError(this.handleValidationError));
  }
  getCustemerWithSearch({ page = 0, size = 2, search = '' }: { page?: number; size?: number; search?: string; } = {}): Observable<Customer[]>{
    return this.http.get<Customer[]>(this.apiHost + 'api/customer/search?page=' + page + '&size=' + size + '&search=' + search, {headers: this.headers}).pipe(catchError(this.handleError));
  }
  getNumberOfCustomersWithSearch(search: string = ''): Observable<number>{
    return this.http.get<number>(this.apiHost + 'api/customer/amount?search=' + search,{headers: this.headers}).pipe(catchError(this.handleValidationError));
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

  private handleError(error: HttpErrorResponse) {
    if(error.status == 400){
      var map = new Map<string, string>();
      Object.keys(error.error).forEach(key => {  
        map.set(key, error.error[key] )
      });
      localStorage.setItem('errormap', JSON.stringify(Array.from(map.entries())));
    }

    return throwError(() => new Error(error.status + '\n' + error.error));
  }
}
