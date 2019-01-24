import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { PetinfoService } from 'src/app/petinfo.service';


@Component({
  selector: 'app-petinfo',
  templateUrl: './Petinfo.component.html',
  styleUrls: ['./Petinfo.component.css']
})

export class PetinfoComponent implements OnInit {

   nameNurse: Array<any>;
    nurseNameSelect='';
   breedNames: Array<any>;
   breedNameSelect='';
  ownerName= '';
   ownerTel= '';
  age= '';
    height= '';
    weight= '';
   petName = '';

  constructor(private petinfoService: PetinfoService,
              private httpClient: HttpClient) {

  }

  ngOnInit() {

    this.petinfoService.getNurse().subscribe(data => {
      this.nameNurse = data;
      console.log(this.nameNurse);
    });
    this.petinfoService.getBreed().subscribe(data => {
      this.breedNames = data;
      console.log(this.breedNames);
    });
    }
  insert() {
  if (this.petName === '' ||  this.breedNameSelect === ''  || this.nurseNameSelect === ''
      || this.weight === '' || this.height === '' || this.ownerName === '' ||
      this.ownerTel === ''||  this.age === '') {
        alert('ใส่ข้อมูลไม่ครบจะไม่ถูกบันทึกนะ');
    } else {
         this.httpClient.post('http://localhost:8080/PetInfo/' + this.petName + '/' +
      this.breedNameSelect+'/'+ this.nurseNameSelect+'/' + this.weight +'/' +this.height
      +'/' +this.ownerName+'/'  +this.ownerTel+'/' +this.age,{})
     .subscribe(
       data => {
         console.log('PUT Request is successful', data);
        },
        error => {
          console.log('Error', error);
        }
      );
    }
    alert('บันทึกเรียบร้อย');
}
}
