import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AdminService } from '../services/admin.service';
import { NgForm } from '@angular/forms';
import { Admin } from '../../../model/Users/admin';
import { BloodBank } from '../../../model/blood-bank.model';
import { BloodBankService } from '../../blood-bank/services/blood-bank.service';

@Component({
  selector: 'app-register-admin',
  templateUrl: './register-admin.component.html',
  styleUrls: ['./register-admin.component.css']
})
export class RegisterAdminComponent implements OnInit {
  public bloodBanks : BloodBank[] = [];
  public admin: Admin = new Admin({user:{}});
  public errorMessage: Error = new Error;
  public errorMap: Map<string, string> = new Map();

  constructor(private adminService: AdminService, private router: Router,private toastr: ToastrService,
          private bloodBankService: BloodBankService) { }

  ngOnInit(): void {
    this.bloodBankService.getAll().subscribe( res => 
        {
          this.bloodBanks = res;
          console.log(this.bloodBanks)
         }, (error) => {
          console.log(error)
          this.errorMessage = error;
          this.toastError();
        }
        );
  }

  public registerAdmin(){

    // this.adminService.registerAdmin(this.admin).subscribe( res => 
    //   {
    //     console.log("reEEs")
    //   }, (error) => {
    //     console.log(error)
    //     this.errorMessage = error;
    //     this.toastError();
    //   });

  }

  saveAdmin(registrationForm: NgForm): void {
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
