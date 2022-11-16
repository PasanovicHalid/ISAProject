import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Questionnaire } from '../model/questionnaire.model';
import { QuestionnaireService } from '../services/questionnaire.service';
import { Gender } from '../edit-user/model/gender';
import { Role } from '../edit-user/model/role';

@Component({
  selector: 'app-fill-form',
  templateUrl: './fill-form.component.html',
  styleUrls: ['./fill-form.component.css'],
})
export class FillFormComponent implements OnInit {
  public questionnaire: Questionnaire = new Questionnaire();
  public errorMessage: Error = new Error();
  public errorMap: Map<string, string> = new Map();
  constructor(
    private questionnaireService: QuestionnaireService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {}
  public saveQuestionnaire(): void {
    //umesto ovoga ce biti trenutno ulogovani korisnik
    this.questionnaire.user = {
      id: -1,
      firstName: 'Nasdf',
      lastName: 'Sasdlk',
      username: 'asdkjkl',
      password: 'sadfsdf123',
      email: 'nesfd@gmail.com',
      gender: Gender.MALE,
      dob: new Date(),
      role: Role.CUSTOMER,
      address: {
        id: -1,
        country: 'Aasdflk',
        city: 'Asdf',
        street: 'Skljk',
        number: '123',
      },
    };
    this.createQuestionnaire();
  }
  public createQuestionnaire() {
    console.log('in createQuestionnaire');
    this.questionnaireService.createQuestionnaire(this.questionnaire).subscribe(
      (res) => {
        console.log('created questionnaire');
      },
      (error) => {
        console.log('erorr is: ');
        console.log(error.message);
        this.errorMessage = error;
        //this.toastError();
      }
    );
  }
}
