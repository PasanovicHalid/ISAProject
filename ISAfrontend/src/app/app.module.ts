import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatLegacyButtonModule as MatButtonModule } from '@angular/material/legacy-button';
import { MatLegacyFormField as MatFormField, MatLegacyFormFieldModule as MatFormFieldModule } from '@angular/material/legacy-form-field';
import { MatLegacyInput as MatInput, MatLegacyInputModule as MatInputModule } from '@angular/material/legacy-input';
import { MatLegacySelectModule as MatSelectModule } from '@angular/material/legacy-select';
import { MaterialModule } from './material/material.module';
import { FormsModule } from '@angular/forms';
import { MatLegacyTableModule as MatTableModule } from '@angular/material/legacy-table';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BloodBankModule } from './modules/blood-bank/blood-bank.module';
import { ToastrModule } from 'ngx-toastr';
import { UserModule } from './modules/user/user.module';
import { ComplaintModule } from './modules/complaint/complaint.module';
import { NgxPaginationModule } from 'ngx-pagination';
import { LoginUserComponent } from './modules/login-user/login-user.component';
import { ForbiddenComponent } from './modules/forbidden/forbidden.component';
import { TokenInterceptor } from './modules/auth/TokenInterceptor';
import { UserService } from './modules/user/services/user.service';
import { AppointmentsModule } from './modules/appointments/appointments.module';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';

@NgModule({
  declarations: [AppComponent, LoginUserComponent, ForbiddenComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MaterialModule,
    MatTableModule,
    MatButtonModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    FormsModule,
    BrowserAnimationsModule,
    BloodBankModule,
    UserModule,
    AppointmentsModule,
    ToastrModule.forRoot(),
    NgxPaginationModule,
    ComplaintModule,
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory,
    }),
  ],
  providers: [
    UserService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
