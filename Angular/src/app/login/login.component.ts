import { Component, OnInit } from '@angular/core';
import { PageService } from '../page.service';
import {HttpClient} from '@angular/common/http';
import {MatDialog} from '@angular/material';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

	Nurse: any={
		nameNurse:'',
		passwordNurse:''
	}

	Doctor: any={
		nameDoctor:'',
		passwordDoctor:''
	}

	check:any=''

  constructor(private app : PageService, private httpClient: HttpClient, private router:Router) { }

  ngOnInit() {
  }

  	login1(){
	    if (this.Nurse.nameNurse === '' || this.Nurse.passwordNurse === '') {
	      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
	    } else {
	      this.httpClient.get('http://localhost:8080/Nurse/' + this.Nurse.nameNurse + '/' + this.Nurse.passwordNurse,this.Nurse)
	      .subscribe(
	        data =>   {
	          this.check = data;
	          console.log('PUT Request is successful', data);
	          if (this.check === true) {
	            // alert('login sucessful');
	             this.router.navigate(['Pagemenu',{
	              }]);
	          } else {
	            alert('Username หรือ Password ของท่านไม่ถูกต้อง กรุณา login ใหม่');
	          }
	        },
	        error =>  {
	          console.log('Error', error);
	        }
	      );
	    }
  	}

  	login(){
	    if (this.Doctor.nameDoctor === '' || this.Doctor.passwordDoctor === '') {
	      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
	    } else {
	      this.httpClient.get('http://localhost:8080/Doctor/' + this.Doctor.nameDoctor + '/' + this.Doctor.passwordDoctor,this.Doctor)
	      .subscribe(
	        data =>   {
	          this.check = data;
	          console.log('PUT Request is successful', data);
	          if (this.check === true) {
	             //alert('login sucessful');
	            this.router.navigate(['Pagemenu',{
	              }]);
	          } else {
	            alert('Username หรือ Password ของท่านไม่ถูกต้อง กรุณา login ใหม่');
	          }
	        },
	        error =>  {
	          console.log('Error', error);
	        }
	      );
	    }
  	}

}
