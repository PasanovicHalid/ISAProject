import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public test: any;
  constructor( private testService : ServiceService, private router: Router) { }

  ngOnInit(): void {
    console.log("usli ovde")
    this.testService.getHello().subscribe( res => 
      {
        this.test = res;
        console.log("this.test")
      });
  }

}
