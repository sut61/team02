import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TriageService } from '../triage.service';

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

  constructor(private triage:TriageService, private httpClient: HttpClient) { }

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
      alert('กรุณาเลือกชื่อพยาบาล');
    }else if(this.namePetInfoSelect === "") {
      alert('กรุณาเลือกชื่อสัตว์');
    }else if(this.symptom === "") {
      alert('กรุณากรอกลักษณะอาการ');
    }else if(this.triageLevelSelect === "") {
      alert('กรุณาเลือกระดับความฉุกเฉิน');
    }else {
    this.httpClient.post('http://localhost:8080/Triage/' + this.nameNurseSelect + '/' + this.namePetInfoSelect  + '/' + this.symptom + '/' +this.triageLevelSelect, {})  
    .subscribe(
      data =>{
        console.log('PUT Rrquest successfull',data);
        alert('บันทึกข้อมูลแล้ว');
      },
     
      error =>{
        console.log('Error',error);
        alert('กรุณากรอกข้อมูลลักษณะอาการให้ถูกต้อง ขึ้นต้นด้วย a-z, A-Z, ก-ฮ และ ตัวเลข 0-9');
      }
      
    );
    
  }
  
}

}
