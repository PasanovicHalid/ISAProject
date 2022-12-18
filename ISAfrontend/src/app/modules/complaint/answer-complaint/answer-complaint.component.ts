import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ComplaintService } from '../services/complaint.service';
import { NgForm } from '@angular/forms';
import { Complaint } from '../model/complaint.model';

@Component({
  selector: 'app-answer-complaint',
  templateUrl: './answer-complaint.component.html',
  styleUrls: ['./answer-complaint.component.css']
})
export class AnswerComplaintComponent implements OnInit {

  public complaint: Complaint = new Complaint();
  public errorMessage: Error = new Error();
  public errorMap: Map<string, string> = new Map();

  constructor(private complaintService: ComplaintService, private router: Router,private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  public answerComplaint(){

    this.complaintService.answerComplaint(this.complaint).subscribe( res => 
      {
        console.log("reEEs")
      }, (error) => {
        console.log(error)
        this.errorMessage = error;
        this.toastError();
      }
    );
  }

  saveComplaint(answerComplaintForm: NgForm): void {
    if (answerComplaintForm.dirty && answerComplaintForm.valid) {
      this.answerComplaint();
    }
  }

  private toastError() {
    if (String(this.errorMessage).includes('406')) {
      var error = localStorage.getItem('errormap')!;
      this.errorMap = new Map(JSON.parse(error));

      for (let entry of this.errorMap.entries()) {
        this.toastr.error('Validation error: ' + entry[1]);
      }
    } else {
      this.toastr.error(this.errorMessage.message);
    }
  }
}
