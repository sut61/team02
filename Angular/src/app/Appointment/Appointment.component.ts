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

    this.appointmentService.getPeriods().subscribe(data => {
      this.periods = data;
      console.log(this.periods);
    });
    }
  insert() {
  if (this.nameOwnerSelect === '' || this.nameDoctorSelect === '' || this.date === '' || this.periodsSelect === '' ||
      this.note === ''||  this.nameNurseSelect === '') {
        alert('ใส่ข้อมูลไม่ครบจะไม่ถูกบันทึกนะ');
    } else {
         this.httpClient.post('http://localhost:8080/Appointment/' + this.nameOwnerSelect + '/' + this.nameDoctorSelect +'/' + this.date +'/' +this.periodsSelect+'/'  +this.note+'/' +this.nameNurseSelect,{})
     .subscribe(
       data => {
         console.log('PUT Request is successful', data);
        },
        error => {
          console.log('Error', error);
        }
      );
    alert('บันทึกข้อมูลเรียบร้อย');
  }
}

}
