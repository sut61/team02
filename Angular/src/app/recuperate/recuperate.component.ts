import { Component, OnInit } from '@angular/core';
import { HelloService } from '../hello.service';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material';



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

    note='';
    date='';
  constructor(private app : HelloService, private httpClient: HttpClient,private snackBar: MatSnackBar) { }



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
    if (this.nameCageSelect === ""){
      this.snackBar.open('กรุณาเลือกกรง', 'OK', {});
      }else if(this.nameCageTypeSelect === "") {
      this.snackBar.open('กรุณาเลือกประเภทกรง', 'OK', {});
      }else if(this.treatSelect === "") {
      this.snackBar.open('กรุณาเลือกข้อมูลบันทึกอาการ', 'OK', {});
      }else if(this.note === "") {
      this.snackBar.open('กรุณาหมายเหตุ', 'OK', {});
      }else if(this.nameNurseSelect === "") {
      this.snackBar.open('กรุณาเลือกชื่อพยาบาล', 'OK', {});
    } else {

    this.httpClient.post('http://localhost:8080/Recuperate/' + this.nameCageSelect + '/' +
      this.nameCageTypeSelect  +'/' + this.treatSelect +'/' + this.note + '/' + this.nameNurseSelect,{})
     .subscribe(
       data => {
         console.log('PUT Request is successful', data);
         this.snackBar.open('บันทึกข้อมูลเรียบร้อย');
        },
        error => {
          console.log('Error', error);
          this.snackBar.open('บันทึกไม่สำเร็จเพราะช่องหมายเหตุกรอกได้แค่ ภาษาอังกฤษ 1-20 ตัวเท่านั้น');
        }
      );

    }

  }
}
