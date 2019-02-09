import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TreatmentService } from '../treatment.service';

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

  constructor(private treatment:TreatmentService, private httpClient: HttpClient) { }
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
      alert('กรุณาเลือกชื่อสัตวแพทย์');
    }else if(this.namePetInfoSelect === "") {
      alert('กรุณาเลือกชื่อสัตว์');
    }else if(this.nameOwnerSelect === "") {
      alert('กรุณาเลือกชื่อเจ้าของสัตว์');
    }else if(this.symptom === "") {
      alert('กรุณากรอกอาการ');
    }else if(this.nameMedicineSelect === "") {
      alert('กรุณาเลือกชื่อยา');
    }else if(this.dcon === "") {
      alert('กรุณากรอกวันพักฟื้น');
    } else {
    this.httpClient.post('http://localhost:8080/Treatment/' + this.nameDoctorSelect + '/' + this.namePetInfoSelect  + '/' +this.nameOwnerSelect+'/'+this.nameMedicineSelect+'/'+this.symptom+'/'+this.dcon, {})  
    .subscribe(
      data =>{
        console.log('PUT Rrquest successfull',data);
        alert('บันทึกข้อมูลสำเร็จ');
      },
     
      error =>{
        console.log('Error',error);
        alert('กรุณากรอกข้อมูลอาการให้ถูกต้อง ประกอบด้วย a-z, A-Z, ก-ฮ และ ตัวเลข 0-9');
      }
      
    );
    }
  
  }

}

  



