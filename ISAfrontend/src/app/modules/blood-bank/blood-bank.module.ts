import { CommonModule } from '@angular/common';
import { NgModule, ViewChild } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { MaterialModule } from 'src/app/material/material.module';
import { RegisterBanksComponent } from './register-banks/register-banks.component';
import { ListBanksComponent } from './list-banks/list-banks.component';
import { MatLegacySelectModule as MatSelectModule } from '@angular/material/legacy-select';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatLegacyPaginatorModule as MatPaginatorModule } from '@angular/material/legacy-paginator';
import { MatLegacyProgressSpinnerModule as MatProgressSpinnerModule } from '@angular/material/legacy-progress-spinner';
import { Guard } from '../auth/guard';

const routes: Routes = [
  { path: 'register-banks', component: RegisterBanksComponent },
  {
    path: 'list-banks',
    component: ListBanksComponent,
    canActivate: [Guard],
    data: { permittedRoles: ['ROLE_HEADADMIN'] },
  },
];

@NgModule({
  declarations: [RegisterBanksComponent, ListBanksComponent],
  imports: [
    CommonModule,
    MaterialModule,
    MatSelectModule,
    MatSortModule,
    MatPaginatorModule,
    MatProgressSpinnerModule,
    FormsModule,
    ReactiveFormsModule,
    MatSortModule,
    RouterModule.forChild(routes),
  ],
})
export class BloodBankModule {
  @ViewChild(MatSort) sort: MatSort;
}
