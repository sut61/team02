import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { KaewService } from '../kaew.service';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css']
})
export class PayComponent implements OnInit {


    id: Array<any>;
    payInfoId: Array<any>;
    payInfoSelect: any ='';


    nameStatusPay: Array<any>;
    statusPaySelect: any ='';

    
    note: any='';

  	nameNurse: Array<any>;
    nameNurseSelect: any ='';
    
  	constructor(private app : KaewService, private httpClient: HttpClient,private snackBar: MatSnackBar) {

      
    }



  	ngOnInit() {

  	  this.app.getPayInfo().subscribe(data=>{
          this.payInfoId =  data;
          console.log(this.payInfoId);
      })

      this.app.getStatusPay().subscribe(data=>{
          this.nameStatusPay =  data;
          console.log(this.nameStatusPay);
      })
 
 	  this.app.getNurse().subscribe(data=>{
          this.nameNurse =  data;
          console.log(this.nameNurse);
      })
     
    }


    save() {
      if (this.payInfoSelect === "") {

        this.snackBar.open('กรุณาเลือกข้อมูลแจ้งชำระเงิน', 'OK', {});

      } else if (this.statusPaySelect === "") {

        this.snackBar.open('กรุณาเลือกสถานะการชำระเงิน', 'OK', {});

      } else if (this.note === "") {

        this.snackBar.open('กรุณากรอกหมายเหตุ', 'OK', {});

      } else if (this.nameNurseSelect === "") {

        this.snackBar.open('กรุณาเลือกชื่อพยาบาล', 'OK', {});

    }else {
      this.httpClient.post('http://localhost:8080/Pay/' + this.payInfoSelect + '/' + this.statusPaySelect + '/' +  this.note + '/' + this.nameNurseSelect, {})
       .subscribe(
        data =>{
         console.log('PUT Request is successful', data);
            this.snackBar.open('บันทึกสำเร็จ', 'OK', {});
        },

        error => {
          console.log('Error', error);

            this.snackBar.open('ช่องหมายเหตุ ต้องเป็นภาษาไทย หรือ ภาษาอังกฤษ หรือ 0-9 หรือ - จำนวน 1-30 ตัวเท่านั้น', 'OK', {});
            
        }

       ); 

    }

  }

  
}