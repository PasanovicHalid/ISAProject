import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Questionnaire } from '../model/questionnaire.model';
import { QuestionnaireService } from '../services/questionnaire.service';
import { Gender } from '../edit-user/model/gender';
import { Role } from '../edit-user/model/role';
import { Customer } from 'src/app/model/Users/customer';
import { UserService } from '../services/user.service';
import { FormDTO } from '../model/formDTO.model';

@Component({
  selector: 'app-fill-form',
  templateUrl: './fill-form.component.html',
  styleUrls: ['./fill-form.component.css'],
})
export class FillFormComponent implements OnInit {
  public questionnaire: FormDTO = new FormDTO();
  public errorMessage: Error = new Error();
  public errorMap: Map<string, string> = new Map();
  public loggedCustomer: any = { gender: 'FEMALE' };
  // public loggedCustomer: any = null;

  genders = Gender;
  constructor(
    public userService: UserService,
    private questionnaireService: QuestionnaireService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.loggedCustomer.gender = Gender.FEMALE;
    this.userService
      .getUserById(localStorage.getItem('loggedUserId'))
      .subscribe((res) => {
        console.log('res');
        console.log(res);
        this.loggedCustomer = res;
      });
    console.log('customer');
    console.log(this.loggedCustomer);
  }
  public saveQuestionnaire(): void {
    //umesto ovoga ce biti trenutno ulogovani korisnik

    this.questionnaire.customerId = localStorage.getItem('loggedUserId');
    this.createQuestionnaire();
  }
  public createQuestionnaire() {
    if (this.loggedCustomer.gender !== 'FEMALE') {
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
