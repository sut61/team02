
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
    treatmentId: Array<any>;
    treatmentIdSelect: any ='';

    nameMed: Array<any>;
    med: Array<any>;
    petName: Array<any>;

    priceSelect: any ='';

    
    note: any='';


    
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
          this.treatmentId =  data;
          console.log(this.treatmentId);
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
      if (this.ownerNameSelect === "") {

	      alert('กรุณาเลือกชื่อเจ้าของสัตว์');

	    } else if (this.treatmentIdSelect === "") {

	      alert('กรุณาเลือกข้อมูลบันทึกอาการ');

	    } else if (this.priceSelect === "") {

	      alert('กรุณาเลือกราคายา');

	    } else if (this.note === "") {

	      alert('กรุณากรอกหมายเหตุ');

	    } else if (this.nameNurseSelect === "") {

	      alert('กรุณาเลือกชื่อพยาบาล');

	  } else {

	      this.httpClient.post('http://localhost:8080/PayInfo/' + this.ownerNameSelect + '/' + this.treatmentIdSelect + '/' + this.priceSelect + '/' + this.note + '/' + this.nameNurseSelect, {})
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