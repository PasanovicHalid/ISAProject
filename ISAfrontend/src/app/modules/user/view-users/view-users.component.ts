import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { MatTableDataSource } from '@angular/material/table';
import { User } from 'src/app/model/Users/user';
import { UserService } from '../services/user.service';
import { Gender } from 'src/app/model/Users/gender';
import { Role } from 'src/app/model/Users/role';



@Component({
  selector: 'app-view-users',
  templateUrl: './view-users.component.html',
  styleUrls: ['./view-users.component.css']
})
export class ViewUsersComponent implements OnInit {

  public tableUsers: User[] = [];
  public users: User[] = [];
  public term: string;
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
        this.tableUsers = this.users
      },
      (error) => {
        this.errorMessage = error;
      }
    );
    
  }
  public searchUsers(name: string): void {
    
    this.tableUsers = this.users.filter((user) =>
    (user.firstName.toLowerCase() + " " +user.lastName.toLowerCase()).includes(name.toLowerCase())
    );
  }
  
}
