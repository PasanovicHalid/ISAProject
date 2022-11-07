import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BloodBankService } from '../services/blood-bank.service';
import { BloodBank } from '../model/blood-bank.model';

@Component({
  selector: 'app-register-banks',
  templateUrl: './register-banks.component.html',
  styleUrls: ['./register-banks.component.css']
})
export class RegisterBanksComponent implements OnInit {

  public bloodBank : BloodBank = new BloodBank();
  public errorMessage: any;

  constructor(private bloodBankService: BloodBankService, private router: Router) { }

  ngOnInit(): void {
  }

  public registerBloodBank(){
    if (!this.isValidInput()) return;

  }
  private isValidInput(): boolean {
    
    if(this.bloodBank.address.number <1 || this.bloodBank.address.number > 200
       || this.bloodBank.address.number == null )
      return false;
  
    return true;
  }
}
