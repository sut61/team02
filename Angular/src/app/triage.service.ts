import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TriageService {

  public API = '//localhost:8080';

  constructor(private http:HttpClient) { }

  getNurse() : Observable<any>{
    return this.http.get(this.API+'/Nurse');
  }

  getPetInfo() : Observable<any>{
    return this.http.get(this.API+'/PetInfo');
  }
  getTriageLevel() : Observable<any>{
    return this.http.get(this.API+'/TriageLevel');
  }
}
