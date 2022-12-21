import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Subscription } from 'rxjs';
import { Appointment } from '../model/appointment';
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

  }

}
