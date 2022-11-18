import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Questionnaire } from '../model/questionnaire.model';
import { QuestionnaireService } from '../services/questionnaire.service';
import { Gender } from '../edit-user/model/gender';
import { Role } from '../edit-user/model/role';
import { Customer } from 'src/app/model/Users/customer';

@Component({
  selector: 'app-fill-form',
  templateUrl: './fill-form.component.html',
  styleUrls: ['./fill-form.component.css'],
})
export class FillFormComponent implements OnInit {
  public questionnaire: Questionnaire = new Questionnaire();
  public errorMessage: Error = new Error();
  public errorMap: Map<string, string> = new Map();
  public logedCustomer: Customer = new Customer();
  genders = Gender;
  constructor(
    private questionnaireService: QuestionnaireService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.logedCustomer = {
      id: -1,
      firstName: 'Loged',
      lastName: 'Customer',
      username: 'logCus99',
      password: 'sadfsdf123',
      email: 'logCus1@gmail.com',
      gender: Gender.FEMALE,
      dob: new Date(),
      role: Role.CUSTOMER,
      address: {
        country: 'Aasdflk',
        city: 'Asdf',
        street: 'Skljk',
        number: '123',
      },
      jmbg: '123321',
      phoneNumber: '066555333',
      profession: 'student',
      professionInfo: 'ftn',
    };
  }
  public saveQuestionnaire(): void {
    //umesto ovoga ce biti trenutno ulogovani korisnik

    this.questionnaire.customer = this.logedCustomer;
    this.createQuestionnaire();
  }
  public createQuestionnaire() {
    if (this.questionnaire.customer.gender.valueOf() !== 2) {
      console.log('not female');
      this.questionnaire.secondState = false;
      this.questionnaire.menstruating = false;
      this.questionnaire.pregnant = false;
    }
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
  public isFemale(customer: Customer) {
    customer.gender.valueOf() === 0;
  }
}
