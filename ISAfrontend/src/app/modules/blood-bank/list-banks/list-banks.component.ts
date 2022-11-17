import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { MatTableDataSource } from '@angular/material/table';
import { BloodBank } from 'src/app/model/blood-bank.model';
import { BloodBankService } from '../services/blood-bank.service';
import { MatSort, Sort } from '@angular/material/sort';

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
    'rating',
  ];
  public bloodBanks: any;
  // public bloodBanks: BloodBank[] = [];
  public errorMessage: any;
  @ViewChild(MatSort) sort: MatSort;
  constructor(
    private bloodBankService: BloodBankService,
    private router: Router,
    private toastr: ToastrService
  ) {
    this.bloodBankService.getBloodBanks().subscribe(
      (res) => {
        this.bloodBanks = res;
        this.dataSource.data = res;
        this.dataSource.sort = this.sort;
      },
      (error) => {
        this.errorMessage = error;
      }
    );
  }

  // sortData(sort: Sort) {
  //   const data = this.bloodBanks.slice();
  //   if (!sort.active || sort.direction === '') {
  //     this.sortedData = data;
  //     return;
  //   }
  //   this.sortedData = data.sort((a, b) => {
  //     const isAsc = sort.direction === 'asc';
  //     switch (sort.active) {
  //       case 'name':
  //         return compare(a.name, b.name, isAsc);
  //       default:
  //         return 0;
  //     }
  //   });
  // }

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
  }

  public chooseBloodBank(bankId: number) {}
}
function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}
