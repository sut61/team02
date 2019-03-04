import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TreatmentService } from '../treatment.service';
import {MatSnackBar} from '@angular/material';
@Component({
  selector: 'app-treatment',
  templateUrl: './treatment.component.html',
  styleUrls: ['./treatment.component.css']
})
export class TreatmentComponent implements OnInit {

  nameDoctor : Array<any>;
  nameDoctorSelect :any = '';

  petName : Array<any>;
  namePetInfoSelect :any = '';

  nameOwner : Array<any>;
  nameOwnerSelect :any = '';



  nameMedicine : Array<any>;
  nameMedicineSelect :any = '';

  symptom :any = '';
  dcon :any = '';

  constructor(private treatment:TreatmentService, private httpClient: HttpClient,private snackBar: MatSnackBar) { }
  ngOnInit() {
    this.treatment.getDoctor().subscribe(data=>{
        this.nameDoctor = data;
        console.log(this.nameDoctor);
    })
    this.treatment.getPetInfo().subscribe(data=>{
      this.petName = data;
      console.log(this.petName);
  })
    this.treatment.getOwner().subscribe(data=>{
      this.nameOwner = data;
      console.log(this.nameOwner);
})
  this.treatment.getMedicine().subscribe(data=>{
    this.nameMedicine = data;
    console.log(this.nameMedicine);
})

  }

  save(){
    if(this.nameDoctorSelect === ""){
      this.snackBar.open('กรุณาเลือกชื่อสัตวแพทย์', 'OK', {});
    }else if(this.namePetInfoSelect === "") {
      this.snackBar.open('กรุณาเลือกชื่อสัตว์', 'OK', {});
    }else if(this.nameOwnerSelect === "") {
      this.snackBar.open('กรุณาเลือกชื่อเจ้าของสัตว์', 'OK', {});
    }else if(this.symptom === "") {
      this.snackBar.open('กรุณากรอกอาการ', 'OK', {});
    }else if(this.nameMedicineSelect === "") {
      this.snackBar.open('กรุณาเลือกชื่อยา', 'OK', {});
    }else if(this.dcon === "") {
      this.snackBar.open('กรุณากรอกวันพักฟื้น', 'OK', {});
    } else {
    this.httpClient.post('http://localhost:8080/Treatment/' + this.nameDoctorSelect + '/' + this.namePetInfoSelect  + '/' +this.nameOwnerSelect+'/'+this.nameMedicineSelect+'/'+this.symptom+'/'+this.dcon, {})  
    .subscribe(
      data =>{
        console.log('PUT Rrquest successfull',data);
        this.snackBar.open('บันทึกข้อมูลสำเร็จ', 'OK', {});
      },
     
      error =>{
        console.log('Error',error);
        this.snackBar.open('กรุณากรอกข้อมูลอาการให้ถูกต้อง ประกอบด้วย a-z, A-Z, ก-ฮ และ ตัวเลข 0-9', 'OK', {});
      }
      
    );
    }
  
  }

}

  



