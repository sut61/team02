import { Component, OnInit } from '@angular/core';
import { PageService } from '../page.service';
import {HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-medical',
  templateUrl: './medical.component.html',
  styleUrls: ['./medical.component.css']
})
export class MedicalComponent implements OnInit {


    nameCompany: Array<any>;
    nameCompanySelect='';
    nameMed: Array<any>;
    nameMedicineSelect='';
    number='';
    type: Array<any>;
    typeMedicineSelect='';
    note='';
    nameNurse: Array<any>;
    nurseNameSelect='';


  constructor(private pageService : PageService, private httpClient: HttpClient) { }



  ngOnInit() {
    this.pageService.getCompany().subscribe(data=>{
          this.nameCompany =  data;
          console.log(this.nameCompany);
      });

    this.pageService.getMedicine().subscribe(data=>{
          this.nameMed =  data;
          console.log(this.nameMed);
      });
    this.pageService.getMedicine().subscribe(data=>{
          this.type =  data;
          console.log(this.type);
      });
    this.pageService.getNurse().subscribe(data=>{
          this.nameNurse =  data;
          console.log(this.nameNurse);
      });

    }

    save() {
                 if (this.nameCompanySelect === '' || this.nameMedicineSelect === ''  || this.number === '' || this.note === ''
                  || this.nurseNameSelect === '') {
                   alert('กรุณากรอกข้อมูลให้ครบถ้วน');
                 } else {
                 this.httpClient.post('http://localhost:8080/OrderMedicine/' + this.nameCompanySelect + '/' + this.nameMedicineSelect + '/' +
                     this.number +  '/' + this.note + '/' + this.nurseNameSelect,{})
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


