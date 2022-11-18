import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { MatTableDataSource } from '@angular/material/table';
import { BloodBank } from 'src/app/model/blood-bank.model';
import { BloodBankService } from '../services/blood-bank.service';
import { LiveAnnouncer } from '@angular/cdk/a11y';
import { MatSort, Sort } from '@angular/material/sort';
import { Search } from '../model/search';

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
    'address.country',
    'address.city',
    'address.street',
    'address.number',
  ];
  public bloodBanks: BloodBank[] = [];
  public errorMessage: any;
  public searchQuery : string = '';
  public searchSelect : Search = Search.Name;
  public countrySelect : string = '';
  public citySelect : string = '';
  public cities: string[] = [];
  public countries: string[] = [];

  constructor(
    private bloodBankService: BloodBankService,
    private router: Router,
    private toastr: ToastrService,
    private _liveAnnouncer: LiveAnnouncer
  ) {}

  @ViewChild(MatSort) sort: MatSort;

  ngOnInit(): void {
    this.bloodBankService.getBloodBanks().subscribe(
      (res) => {
        this.bloodBanks = res;
        this.dataSource.data = res;
        var addresses = this.getFilterObject(res, 'address')
        this.cities = this.getFilterObject(addresses, "city")
        this.countries = this.getFilterObject(addresses, "country")
        this.dataSource.sortingDataAccessor = this.pathDataAccessor;
        this.dataSource.filterPredicate = (data: BloodBank, filter: string) => {
          var firstFilter = true;
            switch (this.searchSelect) {
                case 'Name':
                  firstFilter = data.name.toLowerCase().indexOf(filter.toLowerCase()) != -1;
                  break;
                case 'Address':
                  let address = data.address.country.toLowerCase() + ' ' + data.address.city.toLowerCase()
                  + ' ' + data.address.street.toLowerCase() + ' ' + data.address.number.toLowerCase();
                  firstFilter = (address.indexOf(filter.toLowerCase()) != -1);
                  break;
                default:
                  firstFilter = true;
                  break;
            }
          return firstFilter && (data.address.country.toLowerCase().indexOf(this.countrySelect.toLowerCase()) != -1)
          && (data.address.city.toLowerCase().indexOf(this.citySelect.toLowerCase())  != -1);
        }
      },
      (error) => {
        this.errorMessage = error;
      }
    );
    console.log(this.bloodBanks[0]);
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }

  announceSortChange(sortState: Sort) {
    // This example uses English messages. If your application supports
    // multiple language, you would internationalize these strings.
    // Furthermore, you can customize the message to add additional
    // details about the values being sorted.
    if (sortState.direction) {
      this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }

  public chooseBloodBank(bankId: number) {}

  private pathDataAccessor(item: any, path: string): any {
    return path.split('.')
      .reduce((accumulator: any, key: string) => {
        return accumulator ? accumulator[key] : undefined;
      }, item);
  }

  applyFilter(searchQuery: string) {
    this.searchQuery = searchQuery;
    this.dataSource.filter = searchQuery;
  }

  applySecondaryFilter() {
    this.dataSource.filter = this.searchQuery;
  }

  getFilterObject(fullObj: any[], key: string | number) {
    const uniqChk: any[] = [];
    fullObj.filter((obj) => {
      if (!uniqChk.includes(obj[key])) {
        uniqChk.push(obj[key]);
      }
      return obj;
    });
    return uniqChk;
  }
}
