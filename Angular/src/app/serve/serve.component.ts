import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { ServeService } from 'src/app/serve.service';


@Component({
  selector: 'app-serve',
  templateUrl: './serve.component.html',
  styleUrls: ['./serve.component.css']
})
export class ServeComponent implements OnInit {
  list: Array<any>;
  TypeList='';
  comment='';
  nameNurse: Array<any>;
  nameNurseSelect='';
  ownerName: Array<any>;
  ownerNameSelect: any ='';

  constructor(private serveService: ServeService,
                            private httpClient: HttpClient) { }

  ngOnInit() {

  this.serveService.getNurse().subscribe(data => {
        this.nameNurse = data;
        console.log(this.nameNurse);
      });
      this.serveService.getType().subscribe(data => {
        this.list = data;
        console.log(this.list);
      });
     this.serveService.getOwner().subscribe(data=>{
             this.ownerName =  data;
             console.log(this.ownerName);
         })
  }

insert() {
  if (this.ownerNameSelect === '' ) {alert('กรุณาเลือกข้อมูล Owner');}
  else if ( this.TypeList === ''  ) {alert('กรุณาเลือกข้อมูล รายการ');}
  else if (  this.nameNurseSelect === '')   {alert('กรุณาเลือกข้อมูล Nurse');}
  else if (  this.comment === '' ) {alert('กรอกข้อมูลเพิ่มเติม'); }
  else if (  this.comment >=  'A' &&  this.comment <= 'Z' ) {alert('กรอกข้อมูลไม่ตรงเงื่อนไข'); }
  else if (  this.comment >=  'a' &&  this.comment <= 'z' ) {alert('กรอกข้อมูลไม่ตรงเงื่อนไข'); }
    else {
         this.httpClient.post('http://localhost:8080/Serve/' + this.ownerNameSelect + '/' +
      this.TypeList+'/'+ this.nameNurseSelect+'/' + this.comment,{})
     .subscribe(
       data => {
         console.log('PUT Request is successful', data);
         alert('บันทึกเรียบร้อย');
        },
        error => {
          console.log('Error', error);
          alert('มีข้อผิดพลาด');
        }
      );

    }

}
}
