import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { AppointmentService } from 'src/app/Appointment.service';
@Component({
  selector: 'app-Appointment',
  templateUrl: './Appointment.component.html',
  styleUrls: ['./Appointment.component.css']
})
export class AppointmentComponent implements OnInit {

    nameNurse: Array<any>;
    nameNurseSelect='';

    nameDoctor: Array<any>;
    nameDoctorSelect='';

    periods: Array<any>;
    periodsSelect='';

    petName: Array<any>;
    namePetSelect='';

    ownerName: Array<any>;
    nameOwnerSelect='';


    note='';
    date='';

  constructor(private appointmentService: AppointmentService,
              private httpClient: HttpClient) {

  }

  ngOnInit() {

    this.appointmentService.getNurse().subscribe(data => {
      this.nameNurse = data;
      console.log(this.nameNurse);
    });
    this.appointmentService.getDoctor().subscribe(data => {
      this.nameDoctor = data;
      console.log(this.nameDoctor);
    });

    this.appointmentService.getOwner().subscribe(data => {
      this.ownerName = data;
      console.log(this.ownerName);
    });

    this.appointmentService.getPetInfo().subscribe(data => {
      this.petName = data;
      console.log(this.petName);
    });

    this.appointmentService.getPeriods().subscribe(data => {
      this.periods = data;
      console.log(this.periods);
    });
    }
  insert() {
  if (this.nameOwnerSelect === '') {
        alert('กรุณาเลือกชื่อเจ้าของสัตว์เลี้ยง');
    }else if (this.namePetSelect === '') {
        alert('กรุณาเลือกชื่อสัตวืเลี้ยง');
    }else if (this.nameDoctorSelect === '') {
        alert('กรุณาเลือกชื่อสัตว์แพทย์');
    }else if (this.date === '') {
        alert('กรุณาเลือกวันเดือนปี');
    }else if (this.periodsSelect === '') {
        alert('กรุณาเลือกช่วงเวลา');
    }else if (this.note === '') {
        alert('กรุณากรอกหมายเหตุ');
    }else if (this.nameNurseSelect === '') {
        alert('กรุณาเลือกชื่อพยาบาล');
    } else {
         this.httpClient.post('http://localhost:8080/Appointment/' + this.nameOwnerSelect + '/' + this.namePetSelect +'/'
         + this.nameDoctorSelect +'/' + this.date +'/' +this.periodsSelect+'/'  +this.note+'/' +this.nameNurseSelect,{})
     .subscribe(
       data => {
         console.log('PUT Request is successful', data);
          alert('บันทึกข้อมูลสำเร็จ');
        },
        error => {
          console.log('Error', error);
          alert('กรุณากรอกข้อมูลให้ถูกต้อง ต้องประกอบด้วย a-z, A-Z, 0-9, ก-ฮ');
        }
      );

  }
}

}
