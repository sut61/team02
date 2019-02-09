import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServeService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getType() : Observable<any>{
    return this.http.get(this.API+'/Type');
  }
    getNurse(): Observable<any> {
    return this.http.get(this.API +'/Nurse');
  }
  getOwner() : Observable<any>{
    return this.http.get(this.API+'/Owner');
  }

}
