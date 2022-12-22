import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewCustomersAppointmentComponent } from './modules/appointments/view-customers-appointment/view-customers-appointment.component';

const routes: Routes = [
  {path: 'view-customers-appointments', component: ViewCustomersAppointmentComponent
  //, children:[ { path: '', component:}]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
