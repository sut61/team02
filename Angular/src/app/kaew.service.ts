import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class KaewService {

  public API = '//localhost:8080';


  constructor(private http: HttpClient) {}

  	public  getPayInfo() :  Observable<any>{
    return this.http.get(this.API+'/PayInfo');
  	}

    public  getPetInfo() :  Observable<any>{
    return this.http.get(this.API+'/PetInfo');
    }

  	public  getMedicine() :  Observable<any>{
    return this.http.get(this.API+'/Medicine');
  	}

  	public  getTreatment() :  Observable<any>{
    return this.http.get(this.API+'/Treatment');
  	}

  	public  getNurse() :  Observable<any>{
    return this.http.get(this.API+'/Nurse');
  	}

    public  getOwner() :  Observable<any>{
    return this.http.get(this.API+'/Owner');
    }


    public  getStatusPay() :  Observable<any>{
    return this.http.get(this.API+'/StatusPay');
    }

  


  	
}
