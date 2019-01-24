
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { KaewService } from '../kaew.service';



@Component({
  selector: 'app-paymentinfo',
  templateUrl: './paymentinfo.component.html',
  styleUrls: ['./paymentinfo.component.css']
})

export class PaymentinfoComponent implements OnInit {
  	
  	nameNurse: Array<any>;
    nameNurseSelect: any ='';

    ownerName: Array<any>;
    ownerNameSelect: any ='';

    id: Array<any>;
    treatmentIdSelect: any ='';

    nameMed: Array<any>;
    med: Array<any>;
    petName: Array<any>;

    priceSelect: any ='';


    
  	constructor(private app : KaewService, private httpClient: HttpClient) {

      
    }



  	ngOnInit() {
    
  	this.app.getNurse().subscribe(data=>{
          this.nameNurse =  data;
          console.log(this.nameNurse);
      })

    this.app.getOwner().subscribe(data=>{
          this.ownerName =  data;
          console.log(this.ownerName);
      })

  	 this.app.getTreatment().subscribe(data=>{
          this.id =  data;
          console.log(this.id);
      })

      this.app.getMedicine().subscribe(data=>{
          this.nameMed =  data;
          console.log(this.nameMed);
      })

      this.app.getPetInfo().subscribe(data=>{
          this.petName =  data;
          console.log(this.petName);
      })
      
     
    }


    save() {
      if (this.ownerNameSelect === '' || this.treatmentIdSelect === ''  || this.nameNurseSelect === '' ) {
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
      } else {
      this.httpClient.post('http://localhost:8080/PayInfo/' + this.ownerNameSelect + '/' + this.treatmentIdSelect + '/' + this.priceSelect + '/' + this.nameNurseSelect, {})
       .subscribe(
        data =>{
         console.log('PUT Request is successful', data);
        },

        error => {
          console.log('Error', error);
        }

       );

      }

      alert('ยืนยันการบันทึก');

    }

}
