import { Component, OnInit } from '@angular/core';
import { HelloService } from '../hello.service';
import {HttpClient} from '@angular/common/http';



@Component({
  selector: 'app-recuperate',
  templateUrl: './recuperate.component.html',
  styleUrls: ['./recuperate.component.css']
})
export class RecuperateComponent implements OnInit {


   nametreat: Array<any>;
    treatSelect='';

  	nameCage: Array<any>;
  	nameCageSelect='';

  	nameCageType: Array<any>;
    nameCageTypeSelect='';

  	nameNurse: Array<any>;
  	nameNurseSelect='';
    
  	
  	date='';
	constructor(private app : HelloService, private httpClient: HttpClient) { }

  

  ngOnInit() {
  	this.app.getTreatment().subscribe(data=>{
          this.nametreat =  data;
          console.log(this.nametreat);
      })

  	this.app.getCage().subscribe(data=>{
          this.nameCage =  data;
          console.log(this.nameCage);
      })
	  this.app.getCageType().subscribe(data=>{
          this.nameCageType =  data;
          console.log(this.nameCageType);
      })

    this.app.getNurse().subscribe(data=>{
          this.nameNurse =  data;
          console.log(this.nameNurse);
      })
    }

    save() {
    if (this.nameCageSelect === ''      || this.nameCageTypeSelect === '' || this.treatSelect === '' ||  this.nameNurseSelect === '') {
      alert('กรอกข้อมูลให้ครบถ้วน');
    } else {
    this.httpClient.post('http://localhost:8080/Recuperate/' + this.nameCageSelect + '/' +
      this.nameCageTypeSelect  +'/' + this.treatSelect + '/' + this.nameNurseSelect,{})
     .subscribe(
       data => {
         console.log('PUT Request is successful', data);
        },
        error => {
          console.log('Error', error);
        }
      );
      
    }
    alert('บันทึกข้อมูลเรียบร้อย');
  }
}
