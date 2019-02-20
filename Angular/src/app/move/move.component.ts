import { Component, OnInit } from '@angular/core';
import { NachaService } from '../nacha.service';
import {HttpClient} from '@angular/common/http';



@Component({
  selector: 'app-move',
  templateUrl: './move.component.html',
  styleUrls: ['./move.component.css']
})
export class MoveComponent implements OnInit {


    namerec: Array<any>;
    recSelect='';

    ownerName : Array<any>;
  	nameOwnerSelect :any = '';

  	nameCage: Array<any>;
  	nameCageSelect='';

  	

  	nameNurse: Array<any>;
  	nameNurseSelect='';
    date='';
  	note='';

	constructor(private app : NachaService, private httpClient: HttpClient) { }



  ngOnInit() {
  	this.app.getRecuperate().subscribe(data=>{
          this.namerec =  data;
          console.log(this.namerec);
      })

      this.app.getOwner().subscribe(data=>{
      this.ownerName = data;
      console.log(this.ownerName);
})

  	this.app.getCage().subscribe(data=>{
          this.nameCage =  data;
          console.log(this.nameCage);
      })
	  

    this.app.getNurse().subscribe(data=>{
          this.nameNurse =  data;
          console.log(this.nameNurse);
      })
    }


    save() {
      if (this.recSelect === '' || this.nameOwnerSelect === '' || this.nameCageSelect == '' ||  this.date === '' || this.note === '' || this.nameNurseSelect === '') {
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
      } else {
      this.httpClient.post('http://localhost:8080/Move/' + this.recSelect + '/' + this.nameOwnerSelect + '/' + this.nameCageSelect + '/' +  this.date + '/' + this.note + '/' + this.nameNurseSelect, {})
       .subscribe(
        data =>{
         console.log('PUT Request is successful', data);alert('บันทึกข้อมูลเรียบร้อย');
        },

        error => {
          console.log('Error', error);
          alert('บันทึกไม่สำเร็จเพราะช่องหมายเหตุกรอกได้แค่ ภาษาอังกฤษและภาษาไทย');
        }

       );



      }



    }

}
