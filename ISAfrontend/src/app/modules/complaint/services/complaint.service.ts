import { Injectable } from '@angular/core';
import {
  HttpHeaders,
  HttpClient,
  HttpErrorResponse,
  HttpParams,
} from '@angular/common/http';
import { Observable, catchError, throwError, map } from 'rxjs';
import { Complaint } from '../model/complaint.model';

@Injectable({
  providedIn: 'root'
})
export class ComplaintService {

  apiHost: string = 'http://localhost:8086/';
  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  answerComplaint(complaint: any): Observable<Complaint> {
    return this.http
      .put<Complaint>(this.apiHost + 'api/complaint', complaint, {
        headers: this.headers,
      })
      .pipe(catchError(this.handleError));
  }

  getAll(): Observable<Complaint[]> {
    return this.http.get<Complaint[]>(this.apiHost + 'api/complaint', { headers: this.headers }).pipe(catchError(this.handleError));
  }

  getUnansweredComplaints(page: number= 0, size: number = 5): Observable<Complaint[]>{
    return this.http.get<Complaint[]>(this.apiHost + 'api/complaint?page=' +page +'&size=' + size, {headers: this.headers}).pipe(catchError(this.handleError));
  }

  getNumberOfUnansweredComplaintss():  Observable<number>{
    return this.http.get<number>(this.apiHost + 'api/complaint/amount', {headers: this.headers}).pipe(catchError(this.handleError));
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
