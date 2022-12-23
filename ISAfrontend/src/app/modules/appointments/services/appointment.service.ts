import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
  HttpParams,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, filter, Observable, throwError } from 'rxjs';
import { Appointment } from '../model/appointment';
import { AppointmentCreation } from '../model/appointment-creation';
import { BookAppointment } from '../model/book-appointment';
import { PageRequest } from '../requests/page-request';
import { AppointmentBook } from '../model/appointment-book';

@Injectable({
  providedIn: 'root',
})
export class AppointmentService {
  apiHost: string = 'http://localhost:8086/';
  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });
  constructor(private http: HttpClient) {}

  getAllAppointments(): Observable<any> {
    return this.http
      .get<any>(this.apiHost + 'api/appointment', { headers: this.headers })
      .pipe(catchError(this.handleError));
  }

  readAppointment(id: any): Observable<any> {
    return this.http
      .get<any>(this.apiHost + 'api/appointment/' + id, {
        headers: this.headers,
      })
      .pipe(catchError(this.handleError));
  }

  createAppointment(
    appointment: AppointmentCreation
  ): Observable<AppointmentCreation> {
    return this.http
      .post<any>(this.apiHost + 'api/appointment/free', appointment, {
        headers: this.headers,
      })
      .pipe(catchError(this.handleError));
  }

  reserveAppointment(bookAppointment: BookAppointment): Observable<any> {
    return this.http
      .post<any>(this.apiHost + 'api/appointment/book', bookAppointment, {
        headers: this.headers,
      })
      .pipe(catchError(this.handleError));
  }

  cancelAppointment(bookAppointment: BookAppointment): Observable<any> {
    return this.http
      .post<any>(this.apiHost + 'api/appointment/cancel', bookAppointment, {
        headers: this.headers,
      })
      .pipe(catchError(this.handleError));
  }

  checkIfCustomerDidSurvey(customerId: string): Observable<boolean> {
    var httpParams = new HttpParams().set('customerId', customerId);
    return this.http
      .get<boolean>(this.apiHost + 'api/questionnaire/check', {
        headers: this.headers,
        params: httpParams,
      })
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    return throwError(() => new Error(error.status + '\n' + error.error));
  }

  getAllAppointmentsPageable(request: PageRequest): Observable<Appointment[]> {
    var httpParams = new HttpParams()
      .set('startDate', request.startDate)
      .set('startTime', request.startTime)
      .set('page', request.pageIndex)
      .set('size', request.pageSize)
      .set('sort', request.sortColumn + ',' + request.sortDirection);
    return this.http
      .get<any>(this.apiHost + 'api/appointment/pageable/free', {
        headers: this.headers,
        params: httpParams,
      })
      .pipe(catchError(this.handleError));
  }
  getForCustomerId(id: string | null): Observable<Appointment[]> {
    return this.http
      .get<any>(this.apiHost + 'api/appointment/forCustomer/' + id, {
        headers: this.headers,
      })
      .pipe(catchError(this.handleError));
  }

  getDoneAndPendingAppointmentsForBloodBank(adminID: number): Observable<any>{
    return this.http.get<any>(this.apiHost + 'api/appointment/calendar/' + adminID, { headers: this.headers }).pipe(catchError(this.handleError));
  }
}
