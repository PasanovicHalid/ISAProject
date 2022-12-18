import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from 'src/app/material/material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
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
import { AdminViewComplaintsComponent } from './admin-view-complaints/admin-view-complaints.component';
import { AnswerComplaintComponent } from './answer-complaint/answer-complaint.component';

const routes: Routes = [
  { path: 'admin-view-complaints', component: AdminViewComplaintsComponent },
  { path: 'answer-complaint', component: AnswerComplaintComponent},
];

@NgModule({
  declarations: [
    AdminViewComplaintsComponent,
    AnswerComplaintComponent
  ],
  imports: [
    CommonModule
  ]
})
export class ComplaintModule { }
