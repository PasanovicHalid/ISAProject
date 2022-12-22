import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AppointmentService } from '../../appointments/services/appointment.service';
import { BookAppointment } from '../../appointments/model/book-appointment';

@Component({
  selector: 'app-my-appointments',
  templateUrl: './my-appointments.component.html',
  styleUrls: ['./my-appointments.component.css'],
})
export class MyAppointmentsComponent implements OnInit {
  public loggedCustomer: any = null;
  public customerAppointments: any = null;

  constructor(
    private userService: UserService,
    private appointmentService: AppointmentService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    //get logged user
    this.userService
      .getUserById(localStorage.getItem('loggedUserId'))
      .subscribe((res) => {
        console.log('res');
        console.log(res);
        this.loggedCustomer = res;
      });
    console.log('customer');
    console.log(this.loggedCustomer);

    //get appointments of logged user
    this.appointmentService
      .getForCustomerId(localStorage.getItem('loggedUserId'))
      .subscribe((res) => {
        console.log('res');
        console.log(res);
        this.customerAppointments = res;
      });
    console.log(this.customerAppointments);
  }
  public cancelAppointment(id: string) {
    console.log('id of appointment');
    console.log(id);
    const dto: BookAppointment = new BookAppointment();
    dto.customerId = localStorage.getItem('loggedUserId') ?? '-1';
    dto.appointmentId = id;
    this.appointmentService.cancelAppointment(dto).subscribe((res) => {
      console.log('res of cancel: ');
      console.log(res);
      location.reload();
    });
  }
}
