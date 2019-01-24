import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TreatmentService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getDoctor() : Observable<any>{
    return this.http.get(this.API+'/Doctor');
  }
  getPetInfo() : Observable<any>{
    return this.http.get(this.API+'/PetInfo');
  }
  getOwner() : Observable<any>{
    return this.http.get(this.API+'/Owner');
  }
  getMedicine() : Observable<any>{
    return this.http.get(this.API+'/Medicine');
  }
}
