import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { FormGroup, NgForm, FormControl } from '@angular/forms';
import { HeadAdminService } from '../services/head-admin.service';
import { HeadPasswordChange } from '../model/head-password-change.model';

@Component({
  selector: 'app-head-admin-password-change',
  templateUrl: './head-admin-password-change.component.html',
  styleUrls: ['./head-admin-password-change.component.css']
})
export class HeadAdminPasswordChangeComponent implements OnInit {
  
  public admin: HeadPasswordChange = new HeadPasswordChange();
  oldPass: String = '';
  verifyPass: String = '';
  public errorMessage: Error = new Error;
  public errorMap: Map<string, string> = new Map();
  isDisabled: boolean =  true;

  constructor(private headAdminService: HeadAdminService, private router: Router,private toastr: ToastrService) { }

  ngOnInit(): void {
    this.admin.username = localStorage.getItem('HeadAdminUsername')!;
    this.admin.password = localStorage.getItem('HeadAdminPassword')!;
    this.admin.newPassword = '';
  }

  saveChanges(registrationForm: NgForm): void {
    if (registrationForm.dirty && registrationForm.valid) {
      this.changePassword();
    }
  }

  changePassword() :void {
    console.log(this.admin)
    this.headAdminService.savePasswordChanges(this.admin).subscribe(res =>
      {
        if(res == true){
          localStorage.removeItem('HeadAdminUsername');
          localStorage.removeItem('HeadAdminPassword');
          localStorage.removeItem('ForbiddenAccessToHeadAdmin');
          this.toastr.success("Password successfully changed!");
          this.toastr.info("Please login with your new password again!");
          this.router.navigate(['/login']);
        }
        else{
          this.toastr.info("Something went wrong, please try again later!");
          this.router.navigate(['/']);
        }
      }, (error) => {
        console.log(error)
        this.errorMessage = error;
        this.toastError();
      });
  }

  checkPassword(){
    if(this.oldPass == this.admin.password && this.verifyPass == this.admin.newPassword)
      this.isDisabled = false;
    else
      this.isDisabled = true;
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
