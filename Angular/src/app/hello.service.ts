import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class HelloService {

    public API = '//localhost:8080';


  constructor(private http: HttpClient) {}


 public  getTreatment() :  Observable<any>{
    return this.http.get(this.API+'/Treatment');
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
