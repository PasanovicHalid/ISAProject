import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Gender } from '../../user/edit-user/model/gender';
import { Role } from '../../user/edit-user/model/role';
import { CustomerService } from '../../user/services/customer-service.service';
import { AppointmentCreation } from '../model/appointment-creation';
import { AppointmentService } from '../services/appointment.service';

@Component({
  selector: 'app-admin-create-appointment',
  templateUrl: './admin-create-appointment.component.html',
  styleUrls: ['./admin-create-appointment.component.css']
})
export class AdminCreateAppointmentComponent implements OnInit {

  public appointment: AppointmentCreation = new AppointmentCreation();
  public startDayWorkTime: any;
  public endDayWorkTime: any;
  public errorMessage : any;

  constructor(private router: Router, private toastr: ToastrService, private appointmentService: AppointmentService) { }

  ngOnInit(): void { }

  createAppointment() {
    this.appointmentService.createAppointment(this.appointment).subscribe(res => { this.toastr.success("Succsesfuly created an appointment") },
      (error) => {
        this.toastr.error(error.message);
      }
    );
  }
}
