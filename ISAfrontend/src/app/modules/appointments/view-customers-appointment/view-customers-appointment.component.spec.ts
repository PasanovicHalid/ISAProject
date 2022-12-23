import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCustomersAppointmentComponent } from './view-customers-appointment.component';

describe('ViewCustomersAppointmentComponent', () => {
  let component: ViewCustomersAppointmentComponent;
  let fixture: ComponentFixture<ViewCustomersAppointmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewCustomersAppointmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewCustomersAppointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
