import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Customer } from 'src/app/model/Users/customer';
import { Gender } from '../../user/edit-user/model/gender';
import { Role } from '../../user/edit-user/model/role';
import { Questionnaire } from '../../user/model/questionnaire.model';
import { QuestionnaireService } from '../../user/services/questionnaire.service';
import { FormDTO } from '../../user/model/formDTO.model';
import { UserService } from '../../user/services/user.service';

@Component({
  selector: 'app-answer-form',
  templateUrl: './answer-form.component.html',
  styleUrls: ['./answer-form.component.css'],
})
export class AnswerFormComponent implements OnInit {
  public questionnaire: FormDTO = new FormDTO();
  public errorMessage: Error = new Error();
  public errorMap: Map<string, string> = new Map();
  public loggedCustomer: any = null;
  genders = Gender;
  constructor(
    private userService: UserService,
    private questionnaireService: QuestionnaireService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
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
    this.questionnaire.customerId = localStorage.getItem('loggedUserId');
    this.createQuestionnaire();
  }
  public createQuestionnaire() {
    if (this.loggedCustomer.gender.valueOf() !== 2) {
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
