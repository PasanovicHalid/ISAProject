import { HttpClient, HttpErrorResponse, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Questionnaire } from '../model/questionnaire';

@Injectable({
  providedIn: 'root'
})
export class QuestionnaireService {

  apiHost: string = 'http://localhost:8086/';
  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  createQuestionnaire(questionnaire: Questionnaire): Observable<any> {
    return this.http
      .post<any>(this.apiHost + 'api/questionnaire/create_not_present', questionnaire, {
        headers: this.headers,
      })
      .pipe(catchError(this.handleValidationError));
  }

  updateQuestionnaire(questionnaire: Questionnaire): Observable<any> {
    return this.http
      .post<any>(this.apiHost + 'api/questionnaire/update', questionnaire, {
        headers: this.headers,
      })
      .pipe(catchError(this.handleValidationError));
  }

  getQuestionnaireForCustomer(customerId: any): Observable<Questionnaire> {
    var httpParams = new HttpParams()
      .set('customerId', customerId)
    return this.http
      .get<Questionnaire>(this.apiHost + 'api/questionnaire/specific', {
        headers: this.headers,
        params: httpParams
      })
      .pipe(catchError(this.handleValidationError));
  }

  private handleValidationError(error: HttpErrorResponse) {
    return throwError(
      () => new Error(error.status + '\n' + error.error.message)
    );
  }
}
