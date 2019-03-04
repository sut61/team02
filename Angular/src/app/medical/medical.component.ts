import { Component, OnInit } from '@angular/core';
import { PageService } from '../page.service';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material';

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


  constructor(private pageService : PageService, private httpClient: HttpClient, private snackBar: MatSnackBar) { }



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
                 if(this.nameCompanySelect === ""){
                       this.snackBar.open('กรุณาเลือกชื่อบริษัท', 'OK', {});
                     }else if(this.nameMedicineSelect === "") {
                       this.snackBar.open('กรุณาเลือกชื่อยา', 'OK', {});
                     }else if(this.number === "") {
                       this.snackBar.open('กรุณากรอกจำนวนยา', 'OK', {});
                     }else if(this.note === "") {
                       this.snackBar.open('กรุณากรอกหมายเหตุ', 'OK', {});
                     }else if(this.nurseNameSelect === "") {
                       this.snackBar.open('กรุณาเลือกชื่อพยาบาล', 'OK', {});
                     } else {
                 this.httpClient.post('http://localhost:8080/OrderMedicine/' + this.nameCompanySelect + '/' + this.nameMedicineSelect + '/' +
                     this.number +  '/' + this.note + '/' + this.nurseNameSelect,{})
                      .subscribe(
                        data => {
                          console.log('PUT Request is successful', data);
                          this.snackBar.open ('บันทึกข้อมูลสำเร็จ','OK', {});
                         },
                         error => {
                                   console.log('Error', error);
                                   this.snackBar.open('บันทึกไม่สำเร็จเพราะช่องnoteใส่ได้แค่ภาษาไทย0-9 และ - จำนวน1-30ตัวเท่านั้น','OK', {});
                         }
                       );
                 }

               }

}


