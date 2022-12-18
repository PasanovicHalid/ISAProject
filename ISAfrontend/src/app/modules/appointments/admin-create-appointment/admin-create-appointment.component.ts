import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Gender } from '../../user/edit-user/model/gender';
import { Role } from '../../user/edit-user/model/role';
import { CustomerService } from '../../user/services/customer-service.service';

@Component({
  selector: 'app-admin-create-appointment',
  templateUrl: './admin-create-appointment.component.html',
  styleUrls: ['./admin-create-appointment.component.css']
})
export class AdminCreateAppointmentComponent implements OnInit {

  public genders = Object.values(Gender);
  public roles = Object.values(Role);
  public user : any;
  public errorMessage: Error = new Error;
  public errorMap: Map<string, string> = new Map();
  private sub: any;

  constructor(private customerService: CustomerService, private router: Router,private toastr: ToastrService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.customerService.getCustomerByID(+params['id']).subscribe(res => {
        this.user = res
      }, (error) => {
        console.log(error)
        this.errorMessage = error;
        this.toastError();
      })
    })
  }

  public editCustomer(){
    this.customerService.updateCustomer(this.user).subscribe( res => 
      {
        console.log("reEEs")
      }, (error) => {
        console.log(error)
        this.errorMessage = error;
        this.toastError();
      });
  }

  private toastError() {
    if (String(this.errorMessage).includes('406')){
      var error = localStorage.getItem('errormap')!;
      this.errorMap = new Map(JSON.parse(error));

      for (let entry of this.errorMap.entries()) {
        this.toastr.error('Validation error: ' + entry[1]);
      }
    }
    else{
      this.toastr.error(this.errorMessage.message);
    }
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
