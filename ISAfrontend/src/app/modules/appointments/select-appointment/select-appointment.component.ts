import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Subscription } from 'rxjs';
import { Appointment } from '../model/appointment';
import { BookAppointment } from '../model/book-appointment';
import { AppointmentService } from '../services/appointment.service';

@Component({
  selector: 'app-select-appointment',
  templateUrl: './select-appointment.component.html',
  styleUrls: ['./select-appointment.component.css']
})
export class SelectAppointmentComponent implements OnInit {

  public appointment: Appointment = new Appointment();
  private routeSub: Subscription;

  constructor(
    private router: Router,
    private toastr: ToastrService,
    private appointmentService: AppointmentService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe(params => {
      this.appointmentService.readAppointment(params['id']).subscribe(res => {
        this.appointment = res
      }, (error) => {
        this.toastr.error(error);
      });
    }, (error) => {
      this.toastr.error(error);
    });
  }

  reserveAppointment() {
    var userId = localStorage.getItem('loggedUserId') ?? '-1'
    this.appointmentService.checkIfCustomerDidSurvey(userId).subscribe(res => {
      if (res) {
        var bookAppointment = new BookAppointment();
        bookAppointment.appointmentId = this.appointment.id.toLocaleString()
        bookAppointment.customerId = userId;
        this.appointmentService.reserveAppointment(bookAppointment).subscribe(res => { 
          this.toastr.success("Succsesfuly reserved appointment")
        },(error) => {
          this.toastr.error(error);
        });
      } else {
        this.router.navigate(['answer-form/', this.appointment.id])
      }
    }, (error) => {
      this.toastr.error(error);
    });
  }

}
