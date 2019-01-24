import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {


  public API = '//localhost:8080';

  constructor(private http : HttpClient){}


  public getOwner(): Observable<any> {
    return this.http.get(this.API +'/Owner');
  }

  public getPeriods(): Observable<any> {
    return this.http.get(this.API +'/Period');
  }
  public getDoctor(): Observable<any> {
    return this.http.get(this.API +'/Doctor');
  }
  public getNurse(): Observable<any> {
    return this.http.get(this.API +'/Nurse');
  }
}
