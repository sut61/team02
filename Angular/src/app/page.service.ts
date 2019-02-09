import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';


@Injectable({
  providedIn: 'root'
})
export class PageService {

	  public API = '//localhost:8080';

	  constructor(private http: HttpClient) { }

	  public  getNurse() :  Observable<any>{
	    return this.http.get(this.API+'/Nurse');
	  }

	  public  getDoctor() :  Observable<any>{
	    return this.http.get(this.API+'/Doctor');
	  }

	  public  getCompany(): Observable<any>{
      return this.http.get(this.API+'/Company');
    }

    public  getMedicine(): Observable<any>{
      return this.http.get(this.API+'/Medicine');
    }

    public  getCheckStatus(): Observable<any>{
          return this.http.get(this.API+'/CheckStatus');
    }

    public  getOrderMedicine() :  Observable<any>{
          return this.http.get(this.API+'/OrderMedicine');
    }
}
