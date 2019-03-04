import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { AppointmentService } from 'src/app/Appointment.service';
import {MatSnackBar} from '@angular/material';
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
              private httpClient: HttpClient,
              private snackBar: MatSnackBar) {

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
        this.snackBar.open ('กรุณาเลือกชื่อเจ้าของสัตว์เลี้ยง','OK', {});
    }else if (this.namePetSelect === '') {
        this.snackBar.open ('กรุณาเลือกชื่อสัตวืเลี้ยง','OK', {});
    }else if (this.nameDoctorSelect === '') {
        this.snackBar.open ('กรุณาเลือกชื่อสัตว์แพทย์','OK', {});
    }else if (this.date === '') {
       this.snackBar.open ('กรุณาเลือกวันเดือนปี','OK', {});
    }else if (this.periodsSelect === '') {
        this.snackBar.open ('กรุณาเลือกช่วงเวลา','OK', {});
    }else if (this.note === '') {
        this.snackBar.open ('กรุณากรอกหมายเหตุ','OK', {});
    }else if (this.nameNurseSelect === '') {
        this.snackBar.open ('กรุณาเลือกชื่อพยาบาล','OK', {});
    } else {
         this.httpClient.post('http://localhost:8080/Appointment/' + this.nameOwnerSelect + '/' + this.namePetSelect +'/'
         + this.nameDoctorSelect +'/' + this.date +'/' +this.periodsSelect+'/'  +this.note+'/' +this.nameNurseSelect,{})
     .subscribe(
       data => {
         console.log('PUT Request is successful', data);
          this.snackBar.open ('บันทึกข้อมูลสำเร็จ','OK', {});
        },
        error => {
          console.log('Error', error);
          this.snackBar.open ('กรุณากรอกข้อมูลให้ถูกต้อง ต้องประกอบด้วย a-z, A-Z, 0-9, ก-ฮ','OK', {});
        }
      );

  }
}

}
