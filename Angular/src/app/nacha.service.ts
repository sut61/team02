import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class NachaService {

    public API = '//localhost:8080';


  constructor(private http: HttpClient) {}


 public  getRecuperate() :  Observable<any>{
    return this.http.get(this.API+'/Recuperate');
  }

public getOwner() : Observable<any>{
    return this.http.get(this.API+'/Owner');
  }

 public  getCage() :  Observable<any>{
    return this.http.get(this.API+'/Cage');
  }
	
	public getCageType() :  Observable<any>{
    return this.http.get(this.API+'/CageType');
  }

  public  getNurse() :  Observable<any>{
    return this.http.get(this.API+'/Nurse');
  }


}
