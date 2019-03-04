import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { CancelService } from 'src/app/cancel.service';
import {MatSnackBar} from '@angular/material';
@Component({
  selector: 'app-cancel-app',
  templateUrl: './cancel-app.component.html',
  styleUrls: ['./cancel-app.component.css']
})
export class CancelAppComponent implements OnInit {

    nameNurse: Array<any>;
    nameNurseSelect='';

    appointment: Array<any>;
    nameAppointSelect='';

    status: Array<any>;
    statusSelect='';

    note='';

  constructor(private cancelService: CancelService,
              private httpClient: HttpClient,
              private snackBar: MatSnackBar) {

  }

  ngOnInit() {

    this.cancelService.getNurse().subscribe(data => {
    this.nameNurse = data;
    console.log(this.nameNurse);
    });

    this.cancelService.getAppointment().subscribe(data => {
    this.appointment = data;
    console.log(this.appointment);
    });

    this.cancelService.getStatus1().subscribe(data => {
    this.status = data;
    console.log(this.status);
    });
  }
  insert1() {
  if (this.nameAppointSelect === '') {
        this.snackBar.open ('กรุณาเลือกข้อมูลการนัดหมาย','OK', {});
  }else if (this.statusSelect === '') {
        this.snackBar.open ('กรุณาเลือกสถานะ','OK', {});
  }else if (this.note === '') {
        this.snackBar.open ('กรุณากรอกหมายเหตุ','OK', {});
  }else if (this.nameNurseSelect === '') {
        this.snackBar.open ('กรุณาเลือกชื่อพยาบาล','OK', {});
    } else {
         this.httpClient.post('http://localhost:8080/CancelApp/' + this.nameAppointSelect + '/' + this.statusSelect +'/' +this.note+'/' +this.nameNurseSelect,{})
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
