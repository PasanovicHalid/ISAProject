import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AdminService } from '../services/admin.service';
import { FormGroup, NgForm, FormControl } from '@angular/forms';
import { RegistrationAdmin } from '../model/registration-admin.model';
import { BloodBank } from '../../../model/blood-bank.model';
import { BloodBankService } from '../../blood-bank/services/blood-bank.service';

@Component({
  selector: 'app-register-admin',
  templateUrl: './register-admin.component.html',
  styleUrls: ['./register-admin.component.css']
})
export class RegisterAdminComponent implements OnInit {
  public bloodBanks : BloodBank[] = [];
  public admin: RegistrationAdmin = new RegistrationAdmin({user:{address:{}}});
  public errorMessage: Error = new Error;
  public errorMap: Map<string, string> = new Map();
  private pastDate: Date = new Date(1900,1,1);
  public todaysDate: Date = new Date();

  constructor(private adminService: AdminService, private router: Router,private toastr: ToastrService,
          private bloodBankService: BloodBankService) { }

  ngOnInit(): void {
    this.bloodBankService.getAll().subscribe( res => 
        {
          this.bloodBanks = res;
         }, (error) => {
          this.errorMessage = error;
          this.toastError();
        });
    
  }

  public registerAdmin(){
    this.adminService.registerAdmin(this.admin).subscribe( res => 
      {
        console.log("reEEs")
      }, (error) => {
        console.log(error)
        this.errorMessage = error;
        this.toastError();
      });

  }

  saveAdmin(registrationForm: NgForm): void {
    
    // console.log(this.pastDate)
    // console.log(this.todaysDate)
    // if(this.admin.dob.getFullYear < this.pastDate.getFullYear || (this.admin.dob.getFullYear >= this.todaysDate.getFullYear && this.admin.dob.getMonth >= this.todaysDate.getMonth && this.admin.dob.getDate >= this.todaysDate.getDate)){
    //     console.log("not good")
    // }
    if (registrationForm.dirty && registrationForm.valid) {
        this.registerAdmin();
    }
    
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

}
