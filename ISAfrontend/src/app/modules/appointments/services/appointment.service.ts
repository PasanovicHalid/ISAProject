import { HttpClient, HttpErrorResponse, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, filter, Observable, throwError } from 'rxjs';
import { Appointment } from '../model/appointment';
import { AppointmentCreation } from '../model/appointment-creation';
import { PageRequest } from '../requests/page-request';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  apiHost: string = "http://localhost:8086/";
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

  getAllAppointments(): Observable<any> {
    return this.http.get<any>(this.apiHost + 'api/appointment', { headers: this.headers }).pipe(catchError(this.handleError));
  }

  createAppointment(appointment: AppointmentCreation): Observable<AppointmentCreation> {
    return this.http.post<any>(this.apiHost + 'api/appointment', appointment, { headers: this.headers }).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    return throwError(() => new Error(error.status + '\n' + error.error))
  }

  getAllAppointmentsPageable(request: PageRequest): Observable<Appointment[]> {
    var httpParams = new HttpParams()
      .set('startDate', request.startDate)
      .set('startTime', request.startTime)
      .set('page', request.pageIndex)
      .set('size', request.pageSize)
      .set('sort', request.sortColumn + ',' + request.sortDirection)
    return this.http.get<any>(this.apiHost + 'api/appointment/pageable', { headers: this.headers, params: httpParams }).pipe(catchError(this.handleError));
  }

  getDoneAndPendingAppointmentsForBloodBank(adminID: number): Observable<any>{
    return this.http.get<any>(this.apiHost + 'api/appointment/calendar/' + adminID, { headers: this.headers }).pipe(catchError(this.handleError));
  }
}
