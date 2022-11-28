import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { MatTableDataSource } from '@angular/material/table';
import { UserService } from '../services/user.service';
import { ViewUser } from '../model/view-user.model';



@Component({
  selector: 'app-view-users',
  templateUrl: './view-users.component.html',
  styleUrls: ['./view-users.component.css']
})
export class ViewUsersComponent implements OnInit {

  public users: ViewUser[] = [];
  public search: string;
  public errorMessage: any;
  page: number = 0;
  count: number = 0;
  tableSize: number = 5;

  constructor(
    private userService: UserService,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.getUsers();
    
  }
  public getUsers(searchTerm : string = ''): void{
    this.userService.getUsersWithSearch(searchTerm).subscribe(
      (res) => {
        this.users = res;
        this.count = this.users.length
      },
      (error) => {
        this.errorMessage = error;
      }
    );
  }
  public searchUsers(name: string): void {
    this.getUsers(this.search);
  }
  onTableDataChange(event: any) {
    this.page = event;
    this.getUsers(this.search);
  }
  
}
