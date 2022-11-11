import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  apiHost: string = 'http://localhost:8086/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }
  getHello(): Observable<any>{
    console.log(this.apiHost + "api/bloodbank");
    console.log( this.http.get<String>(this.apiHost + "api/bloodbank", {headers : this.headers}));
    return this.http.get<any>(this.apiHost + "api/bloodbank",  {headers : this.headers});
  }
}
