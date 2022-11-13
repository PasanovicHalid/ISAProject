import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http'
import { Observable, catchError, throwError } from 'rxjs';
import { BloodBank } from '../../../model/blood-bank.model';

@Injectable({
  providedIn: 'root'
})
export class BloodBankService {

  apiHost: string = "http://localhost:8086/";
  headers: HttpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  public keys: string[];
  public errorMap: Map<string, string> = new Map<string, string>();

  constructor(private http: HttpClient) { }

  registerBloodBank(bloodBank: any): Observable<any>{
    return this.http.post<any>(this.apiHost + 'api/bloodbank', bloodBank, {headers: this.headers}).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    var map = new Map<string, string>();
    Object.keys(error.error).forEach(key => {  
      map.set(key, error.error[key] )
    });
    localStorage.setItem('errormap', JSON.stringify(Array.from(map.entries())));
    
    return throwError(() => new Error(error.status +'\n'+ error.error))
  }
}
