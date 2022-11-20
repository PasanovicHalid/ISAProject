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
  public search: string;
  public errorMessage: any;
  page: number = 0;
  count: number = 0;
  tableSize: number = 2;

  constructor(
    private userService: UserService,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.getUsers();
    
  }
  public getUsers(searchTerm : string = ''): void{
    console.log(searchTerm)
    this.userService.getAll(searchTerm).subscribe(
      (res) => {
        this.users = res;
        this.count = this.users.length
        this.tableUsers = this.users
      },
      (error) => {
        this.errorMessage = error;
      }
    );
  }
  public searchUsers(name: string): void {
    console.log(this.search)
    this.getUsers(this.search);
  }
  onTableDataChange(event: any) {
    this.page = event;
    this.getUsers(this.search);
  }
  
}
