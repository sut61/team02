import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

@Injectable({
  providedIn: 'root'
})
export class CancelService {

  public API = '//localhost:8080';

  constructor(private http : HttpClient) {}

  public getAppointment(): Observable<any> {
    return this.http.get(this.API +'/Appointment');
  }

  public getStatus1(): Observable<any> {
    return this.http.get(this.API +'/Status1');
  }

  public getNurse(): Observable<any> {
    return this.http.get(this.API +'/Nurse');
  }

}
