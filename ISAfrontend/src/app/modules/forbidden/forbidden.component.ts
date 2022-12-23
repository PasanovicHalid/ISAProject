import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-forbidden',
  templateUrl: './forbidden.component.html',
  styleUrls: ['./forbidden.component.css']
})
export class ForbiddenComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    var face = document.querySelector("i")!;
    let home = document.getElementById("home")!;

    home.addEventListener("mouseover", function() {
      face.classList.add("fa-smile", "green");
    });
    home.addEventListener("mouseout", function() {
      face.classList.remove("fa-smile", "green");
    });
  }
}
