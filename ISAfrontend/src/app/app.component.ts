import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { StoreService } from './modules/user/services/store.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css', ],
})
export class AppComponent {
  title = 'ISAfrontend';
  role = localStorage.getItem("loggedUserRole");
  loggedUserJwt = localStorage.getItem('token');

  constructor(private router: Router, public store: StoreService) {}

  onLogout() {
    localStorage.removeItem('token');
    this.store.setLoginStatus(0);
    console.log(localStorage.getItem('token'));
    localStorage.clear();
    //location.reload();
    this.router.navigate(['/']);
  }
}
