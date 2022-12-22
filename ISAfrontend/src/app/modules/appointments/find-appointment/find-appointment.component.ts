import { LiveAnnouncer } from '@angular/cdk/a11y';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { merge, tap } from 'rxjs';
import { AppointmentSource } from '../data-sources/appointment-source';
import { PageRequest } from '../requests/page-request';
import { AppointmentService } from '../services/appointment.service';
import { AppointmentBook } from '../model/appointment-book';

@Component({
  selector: 'app-find-appointment',
  templateUrl: './find-appointment.component.html',
  styleUrls: ['./find-appointment.component.css'],
})
export class FindAppointmentComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  public appointmentSource: AppointmentSource;
  public startDate: string = '';
  public startTime: string = '';
  public id: string | null = '';

  public displayedColumns = [
    'appointmentDate',
    'startTime',
    'endTime',
    'bloodBank.name',
    'bloodBank.address',
    'location.rating',
    'executed',
    'bookButton',
  ];

  constructor(
    private appointmentService: AppointmentService,
    private router: Router,
    private toastr: ToastrService,
    private _liveAnnouncer: LiveAnnouncer
  ) {}

  ngOnInit(): void {
    this.appointmentSource = new AppointmentSource(this.appointmentService);
    this.appointmentSource.loadAppointments();
  }

  ngAfterViewInit() {
    this.sort.sortChange.subscribe(() => (this.paginator.pageIndex = 0));

    merge(this.sort.sortChange, this.paginator.page)
      .pipe(tap(() => this.loadAppointments()))
      .subscribe();
  }

  public loadAppointments() {
    this.appointmentSource.loadAppointments(
      new PageRequest({
        pageIndex: this.paginator.pageIndex,
        pageSize: this.paginator.pageSize,
        sortColumn: this.sort.active,
        sortDirection: this.sort.direction,
        startDate: this.startDate,
        startTime: this.startTime,
      })
    );
  }


  public chooseAppointment(bankId: number) {
      this.router.navigate(["select-appointment/", bankId])
  }
}
