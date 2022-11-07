import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { RouterModule, Routes } from "@angular/router";
import { MaterialModule } from "src/app/material/material.module";
import { RegisterBanksComponent } from './register-banks/register-banks.component';

const routes: Routes = [
  { path: 'register-banks', component: RegisterBanksComponent }

];

@NgModule({
  declarations: [
    RegisterBanksComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes)
  ]
})
export class BloodBankModule { }
