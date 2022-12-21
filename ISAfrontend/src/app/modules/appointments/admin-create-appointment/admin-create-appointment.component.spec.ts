import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCreateAppointmentComponent } from './admin-create-appointment.component';

describe('AdminCreateAppointmentComponent', () => {
  let component: AdminCreateAppointmentComponent;
  let fixture: ComponentFixture<AdminCreateAppointmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminCreateAppointmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminCreateAppointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
