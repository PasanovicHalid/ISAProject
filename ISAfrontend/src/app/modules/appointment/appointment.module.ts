import { CommonModule } from '@angular/common';
import { NgModule, ViewChild } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { MaterialModule } from 'src/app/material/material.module';
import { MatSelectModule } from '@angular/material/select';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { AdminCalendarViewComponent } from './admin-calendar-view/admin-calendar-view.component';

const routes: Routes = [
  { path: 'admin-calendar-view', component: AdminCalendarViewComponent }
];

@NgModule({
  declarations: [
    AdminCalendarViewComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    MatSelectModule,
    MatSortModule,
    MatPaginatorModule,
    MatProgressSpinnerModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes),
  ]
})
export class AppointmentModule { }
