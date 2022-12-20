import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerQuestionaireComponent } from './answer-questionaire.component';

describe('AnswerQuestionaireComponent', () => {
  let component: AnswerQuestionaireComponent;
  let fixture: ComponentFixture<AnswerQuestionaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnswerQuestionaireComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnswerQuestionaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
