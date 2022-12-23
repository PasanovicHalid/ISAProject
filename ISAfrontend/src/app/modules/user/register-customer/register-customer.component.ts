import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { NgForm } from '@angular/forms';
import { Customer } from 'src/app/model/Users/customer';
import { CustomerService } from '../services/customer.service';
import { Role } from 'src/app/model/Users/role';

@Component({
  selector: 'app-register-customer',
  templateUrl: './register-customer.component.html',
  styleUrls: ['./register-customer.component.css'],
})
export class RegisterCustomerComponent implements OnInit {
  public customer: Customer = new Customer({});
  public errorMessage: Error = new Error();
  public errorMap: Map<string, string> = new Map();
  public confirmPassword: string = '';

  constructor(
    private customerService: CustomerService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {}

  saveCustomer(registrationForm: NgForm): void {
    console.log('in saveCustomer');
    if (registrationForm.dirty && registrationForm.valid) {
      this.registerCustomer();
    }
  }
  public registerCustomer() {
    console.log('in registerCustomer');
    console.log(this.confirmPassword);
    console.log(this.customer.password);
    if (this.confirmPassword === this.customer.password) {
      console.log('password check passed');
      // this.customer.role = Role.CUSTOMER;
      this.customerService.registerCustomer(this.customer).subscribe(
        (res) => {
          console.log('Registered customer');
          this.toastr.success('Registered user');
          this.router.navigate(['/list-banks']);
        },
        (error) => {
          console.log(error.message);
          this.errorMessage = error;
          this.toastError();
        }
      );
    } else {
      this.toastr.error('Confirmed password must match');
      console.log('Confirmed password must match');
    }
  }
  private toastError() {
    console.log('in toastError');
    console.log(this.errorMessage.message);
    if (String(this.errorMessage.message).includes('Username is taken')) {
      console.log('in if');
      this.toastr.error(this.errorMessage.message);
      console.log('nakon testa');
    }
  }
}
