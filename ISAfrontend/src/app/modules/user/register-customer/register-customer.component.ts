import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { NgForm } from '@angular/forms';
import { Customer } from 'src/app/model/Users/customer';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-register-customer',
  templateUrl: './register-customer.component.html',
  styleUrls: ['./register-customer.component.css']
})
export class RegisterCustomerComponent implements OnInit {

  public customer: Customer = new Customer({});
  public errorMessage: Error = new Error;
  public errorMap: Map<string, string> = new Map();
  public bb : string = '';

  constructor(private customerService: CustomerService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  saveCustomer(registrationForm: NgForm): void {
    console.log("in saveCustomer")
    if (registrationForm.dirty && registrationForm.valid) {

        this.registerCustomer();
    }
  }
  public registerCustomer(){
    console.log("in registerCustomer")
    this.customerService.registerCustomer(this.customer).subscribe(res =>
      {
        console.log("In register customer");
      }, (error) => {
        console.log(error);
        this.errorMessage = error;
        this.toastError()
      })
  }
  private toastError(){
    if (String(this.errorMessage) !== ''){
      this.toastr.error(this.errorMessage.message);
    }
  }

}
