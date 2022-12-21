import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatButtonModule } from '@angular/material/button';
import { MatFormField, MatFormFieldModule } from '@angular/material/form-field';
import { MatInput, MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MaterialModule } from './material/material.module';
import { FormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BloodBankModule } from './modules/blood-bank/blood-bank.module';
import { ToastrModule } from 'ngx-toastr';
import { UserModule } from './modules/user/user.module';
import { NgxPaginationModule } from 'ngx-pagination';
import { LoginUserComponent } from './modules/login-user/login-user.component';
import { ForbiddenComponent } from './modules/forbidden/forbidden.component';
import { TokenInterceptor } from './modules/auth/TokenInterceptor';
import { UserService } from './modules/user/services/user.service';

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
    ToastrModule.forRoot(),
    NgxPaginationModule,
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
