import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { KaewService } from '../kaew.service';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css']
})
export class PayComponent implements OnInit {


    id: Array<any>;
    payInfoSelect: any ='';


    nameStatusPay: Array<any>;
    statusPaySelect: any ='';

    
    note: any='';

  	nameNurse: Array<any>;
    nameNurseSelect: any ='';
    
  	constructor(private app : KaewService, private httpClient: HttpClient) {

      
    }



  	ngOnInit() {

  	  this.app.getPayInfo().subscribe(data=>{
          this.id =  data;
          console.log(this.id);
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

        alert('กรุณาเลือกข้อมูลแจ้งชำระเงิน');

      } else if (this.statusPaySelect === "") {

        alert('กรุณาเลือกสถานะการชำระเงิน');

      } else if (this.note === "") {

        alert('กรุณากรอกหมายเหตุ');

      } else if (this.nameNurseSelect === "") {

        alert('กรุณาเลือกชื่อพยาบาล');

    }else {
      this.httpClient.post('http://localhost:8080/Pay/' + this.payInfoSelect + '/' + this.statusPaySelect + '/' +  this.note + '/' + this.nameNurseSelect, {})
       .subscribe(
        data =>{
         console.log('PUT Request is successful', data);

            alert('บันทึกสำเร็จ');
        },

        error => {
          console.log('Error', error);

            alert('ช่องหมายเหตุ ต้องเป็นภาษาไทย หรือ ภาษาอังกฤษ หรือ 0-9 หรือ - จำนวน 1-30 ตัวเท่านั้น');
        }

       ); 

    }

  }

  
}