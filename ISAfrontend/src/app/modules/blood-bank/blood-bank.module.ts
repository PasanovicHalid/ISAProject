import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { MaterialModule } from 'src/app/material/material.module';
import { RegisterBanksComponent } from './register-banks/register-banks.component';
import { ListBanksComponent } from './list-banks/list-banks.component';

const routes: Routes = [
  { path: 'register-banks', component: RegisterBanksComponent },
  { path: 'list-banks', component: ListBanksComponent },
];

@NgModule({
  declarations: [RegisterBanksComponent, ListBanksComponent],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes),
  ],
})
export class BloodBankModule {}
