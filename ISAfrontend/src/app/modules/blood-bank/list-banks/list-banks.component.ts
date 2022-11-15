import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { MatTableDataSource } from '@angular/material/table';
import { BloodBank } from 'src/app/model/blood-bank.model';
import { BloodBankService } from '../services/blood-bank.service';

@Component({
  selector: 'app-list-banks',
  templateUrl: './list-banks.component.html',
  styleUrls: ['./list-banks.component.css'],
})
export class ListBanksComponent implements OnInit {
  public dataSource = new MatTableDataSource<BloodBank>();
  public displayedColumns = [
    'name',
    'email',
    'address-country',
    'address-city',
    'address-street',
    'address-number',
  ];
  public bloodBanks: BloodBank[] = [];
  public errorMessage: any;

  constructor(
    private bloodBankService: BloodBankService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.bloodBankService.getBloodBanks().subscribe(
      (res) => {
        this.bloodBanks = res;
        this.dataSource.data = res;
      },
      (error) => {
        this.errorMessage = error;
      }
    );
    console.log(this.bloodBanks[0]);
  }
  public chooseBloodBank(bankId: number) {}
}
