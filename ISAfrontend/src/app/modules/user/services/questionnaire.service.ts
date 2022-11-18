import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { Questionnaire } from '../model/questionnaire.model';
@Injectable({
  providedIn: 'root',
})
export class QuestionnaireService {
  apiHost: string = 'http://localhost:8086/';
  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });
  constructor(private http: HttpClient) {}

  createQuestionnaire(questionnaire: any): Observable<any> {
    console.log(questionnaire);
    return this.http
      .post<any>(this.apiHost + 'api/questionnaire/create', questionnaire, {
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
