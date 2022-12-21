import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Gender } from '../../user/edit-user/model/gender';
import { Role } from '../../user/edit-user/model/role';
import { CustomerService } from '../../user/services/customer-service.service';
import { AppointmentCreation } from '../model/appointment-creation';
import { BloodBankAdmin } from '../model/blood-bank-admin';
import { AdminService } from '../services/admin .service';
import { AppointmentService } from '../services/appointment.service';

@Component({
  selector: 'app-admin-create-appointment',
  templateUrl: './admin-create-appointment.component.html',
  styleUrls: ['./admin-create-appointment.component.css']
})
export class AdminCreateAppointmentComponent implements OnInit {

  public appointment: AppointmentCreation = new AppointmentCreation();
  public bloodBank: BloodBankAdmin = new BloodBankAdmin()
  public errorMessage: any;

  constructor(private router: Router,
    private toastr: ToastrService,
    private appointmentService: AppointmentService,
    private adminService: AdminService) { }

  ngOnInit(): void {
      this.adminService.getBloodBankOfAdmin(localStorage.getItem('loggedUserId') ?? "-1").subscribe(res => {
        this.bloodBank = res;
        this.appointment.bankID = this.bloodBank.bankID;
        console.log(this.bloodBank)
      }, (error) => {
        this.toastr.error(error.message);
      })
  }

  createAppointment() {
    this.appointment.start = this.appointment.start + ':00'
    this.appointment.end = this.appointment.end + ':00'
    if ((this.appointment.start < this.appointment.end) && this.checkIfInRange(this.appointment.start)
    && this.checkIfInRange(this.appointment.end)) {
      this.appointmentService.createAppointment(this.appointment).subscribe(res => { this.toastr.success("Succsesfuly created an appointment") },
        (error) => {
          this.toastr.error(error.message);
        }
      );
    } else {
      this.toastr.error("Start and end times are incorrect");
    }
  }

  private checkIfInRange(time: string) : boolean{
    return time >= this.bloodBank.startDayWorkTime && time <= this.bloodBank.endDayWorkTime 
  }
}
