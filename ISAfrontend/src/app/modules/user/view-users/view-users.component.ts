import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { MatTableDataSource } from '@angular/material/table';
import { User } from 'src/app/model/Users/user';
import { UserService } from '../services/user.service';


@Component({
  selector: 'app-view-users',
  templateUrl: './view-users.component.html',
  styleUrls: ['./view-users.component.css']
})
export class ViewUsersComponent implements OnInit {
  public dataSource = new MatTableDataSource<User>();
  public displayedColumns = [
    'name',
    'dob',
    'gender',
    'role',
    'email',
    'address-country',
    'address-city',
    'address-street',
    'address-number',
  ];

  public users: User[] = [];
  public errorMessage: any;

  constructor(
    private userService: UserService,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.userService.getAll().subscribe(
      (res) => {
        this.users = res;
        this.dataSource.data = res;
        console.log(this.users);
      },
      (error) => {
        this.errorMessage = error;
      }
    );
    
  }

}
