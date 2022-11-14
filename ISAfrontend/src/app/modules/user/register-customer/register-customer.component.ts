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
  public bb: string = '';

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
    this.customer.role = Role.CUSTOMER;
    this.customerService.registerCustomer(this.customer).subscribe(
      (res) => {
        console.log('In register customer');
      },
      (error) => {
        console.log('!!!!!error.message!!!!!!!');
        console.log(error.message);
        this.errorMessage = error;
        this.toastError();
      }
    );
  }
  private toastError() {
    console.log('in toastError');
    console.log(this.errorMessage.message);
    if (String(this.errorMessage.message).includes('Username is taken')) {
      console.log('in if');
      // this.toastr.error(this.errorMessage.message);
      this.toastr.error('test');
      console.log('nakon testa');
    }
    //String(this.errorMessage).includes('406')
    // if (true) {
    //   var error = localStorage.getItem('errormap')!;
    //   this.errorMap = new Map(JSON.parse(error));

    //   for (let entry of this.errorMap.entries()) {
    //     this.toastr.error('Validation error: ' + entry[1]);
    //   }
    // } else {
    //   this.toastr.error(this.errorMessage.message);
    // }
  }
}
