import { Component, OnInit } from '@angular/core';
import { HeadAdmin } from 'src/app/model/Users/head-admin';
import { User } from 'src/app/model/Users/user';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  public user : User = new HeadAdmin();

  constructor() { }

  ngOnInit(): void {
  }

}
