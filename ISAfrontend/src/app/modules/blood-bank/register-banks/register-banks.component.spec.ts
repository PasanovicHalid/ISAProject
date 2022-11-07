import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterBanksComponent } from './register-banks.component';

describe('RegisterBanksComponent', () => {
  let component: RegisterBanksComponent;
  let fixture: ComponentFixture<RegisterBanksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterBanksComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterBanksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
