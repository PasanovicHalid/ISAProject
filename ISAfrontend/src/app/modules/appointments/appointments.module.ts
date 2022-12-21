import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminCalendarComponent } from './admin-calendar/admin-calendar.component';
import { Routes, RouterModule } from '@angular/router';
import { FullCalendarModule } from '@fullcalendar/angular';
import { MaterialModule } from 'src/app/material/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatNativeDateModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { NgxPaginationModule } from 'ngx-pagination';
import { AdminCreateAppointmentComponent } from './admin-create-appointment/admin-create-appointment.component';
import { FindAppointmentComponent } from './find-appointment/find-appointment.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSortModule } from '@angular/material/sort';

const routes: Routes = [
  { path: 'calendar', component: AdminCalendarComponent },
  { path: 'create-appointment', component: AdminCreateAppointmentComponent },
  { path: 'find-appointment', component: FindAppointmentComponent },
];

@NgModule({
  declarations: [
    AdminCalendarComponent,
    AdminCreateAppointmentComponent,
    FindAppointmentComponent,
  ],
  imports: [
    CommonModule,
    FullCalendarModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatTableModule,
    MatDatepickerModule,
    NgxPaginationModule,
    MatPaginatorModule,
    MatProgressSpinnerModule,
    MatSortModule,
    RouterModule.forChild(routes),
  ],
})
export class AppointmentsModule { }
