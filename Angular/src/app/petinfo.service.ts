import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

@Injectable({providedIn: 'root'})
export class PetinfoService {
public API = '//localhost:8080';

  constructor(private http : HttpClient){}

   getNurse(): Observable<any> {
    return this.http.get(this.API +'/Nurse');
  }
  public getOwner(): Observable<any> {
    return this.http.get(this.API +'/Owner');
  }
  public getBreed(): Observable<any> {
    return this.http.get(this.API +'/Breed');
  }
}
