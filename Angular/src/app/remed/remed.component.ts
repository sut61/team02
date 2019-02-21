import { Component, OnInit } from '@angular/core';
import { PageService } from '../page.service';
import {HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-remed',
  templateUrl: './remed.component.html',
  styleUrls: ['./remed.component.css']
})
export class RemedComponent implements OnInit {


  	id: Array<any>;
    orderMedicineId: Array<any>;
  	orderMedicineIdSelect='';
    nameMed: Array<any>;
  	nameMedicineSelect='';
  	number='';
  	type: Array<any>;
  	typeMedicineSelect='';
    noteNew='';
    checkStatus: Array<any>;
    checkStatusSelect='';
  	nameNurse: Array<any>;
    nurseNameSelect='';


	constructor(private pageService : PageService, private httpClient: HttpClient) { }



  ngOnInit() {

  	this.pageService.getOrderMedicine().subscribe(data=>{
          this.orderMedicineId =  data;
          console.log(this.orderMedicineId);
      });

     this.pageService.getCheckStatus().subscribe(data=>{
          this.checkStatus =  data;
          console.log(this.checkStatus);
      });
	  this.pageService.getNurse().subscribe(data=>{
          this.nameNurse =  data;
          console.log(this.nameNurse);
      });

    }

     save() {
                     if (this.orderMedicineIdSelect === '' || this.noteNew === '' || this.checkStatusSelect === ''
                      || this.nurseNameSelect === '') {
                       alert('กรุณากรอกข้อมูลให้ครบถ้วน');
                     } else {
                     this.httpClient.post('http://localhost:8080/ReceiveMedicine/' + this.orderMedicineIdSelect + '/' + this.noteNew + '/' +
                          this.checkStatusSelect + '/' + this.nurseNameSelect,{})
                          .subscribe(
                            data => {
                              console.log('PUT Request is successful', data);
                              alert('บันทึกสำเร็จ');
                             },
                             error => {
                                       console.log('Error', error);
                                       alert('บันทึกไม่สำเร็จเพราะช่องnoteใส่ได้แค่ภาษาไทย0-9 และ - จำนวน1-30ตัวเท่านั้น');
                             }
                           );
                     }

                   }
}

