import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TriageService } from '../triage.service';
import {MatSnackBar} from '@angular/material';
@Component({
  selector: 'app-triage',
  templateUrl: './triage.component.html',
  styleUrls: ['./triage.component.css']
})
export class TriageComponent implements OnInit {

  level : Array<any>;
  triageLevelSelect :any = '';

  petName : Array<any>;
  namePetInfoSelect :any = '';

  nameNurse : Array<any>;
  nameNurseSelect :any = '';

  symptom :any = '';

  constructor(private triage:TriageService, private httpClient: HttpClient,private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.triage.getNurse().subscribe(data=>{
      this.nameNurse = data;
      console.log(this.nameNurse);
  })

    this.triage.getPetInfo().subscribe(data=>{
      this.petName = data;
      console.log(this.petName);
  })

  this.triage.getTriageLevel().subscribe(data=>{
    this.level = data;
    console.log(this.level);
})
  }

  save(){
    if(this.nameNurseSelect === ""){
      this.snackBar.open('กรุณาเลือกชื่อพยาบาล', 'OK', {});
    }else if(this.namePetInfoSelect === "") {
      this.snackBar.open('กรุณาเลือกชื่อสัตว์', 'OK', {});
    }else if(this.symptom === "") {
      this.snackBar.open('กรุณากรอกลักษณะอาการ', 'OK', {});
    }else if(this.triageLevelSelect === "") {
      this.snackBar.open('กรุณาเลือกระดับความฉุกเฉิน', 'OK', {});
    }else {
    this.httpClient.post('http://localhost:8080/Triage/' + this.nameNurseSelect + '/' + this.namePetInfoSelect  + '/' + this.symptom + '/' +this.triageLevelSelect, {})  
    .subscribe(
      data =>{
        console.log('PUT Rrquest successfull',data);
        this.snackBar.open('บันทึกข้อมูลแล้ว', 'OK', {});
      },
     
      error =>{
        console.log('Error',error);
        this.snackBar.open('กรุณากรอกข้อมูลลักษณะอาการให้ถูกต้อง ขึ้นต้นด้วย a-z, A-Z, ก-ฮ และ ตัวเลข 0-9', 'OK', {});
      }
      
    );
    
  }
  
}

}
