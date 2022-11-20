import { Injectable } from '@angular/core';
import {
  HttpHeaders,
  HttpClient,
  HttpErrorResponse,
} from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { User } from 'src/app/model/Users/user';
import { ViewUser } from '../model/view-user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  apiHost: string = 'http://localhost:8086/';
  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  getUsersWithSearch(search : string = ''): Observable<ViewUser[]>{
    return this.http.get<ViewUser[]>(this.apiHost + 'api/user?search=' + search, {headers: this.headers}).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if(error.status == 406){
      var map = new Map<string, string>();
      Object.keys(error.error).forEach(key => {  
        map.set(key, error.error[key] )
      });
      localStorage.setItem('errormap', JSON.stringify(Array.from(map.entries())));
    }

    return throwError(() => new Error(error.status + '\n' + error.error));
  }
}
