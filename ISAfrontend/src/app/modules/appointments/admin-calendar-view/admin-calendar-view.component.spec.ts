import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCalendarViewComponent } from './admin-calendar-view.component';

describe('AdminCalendarViewComponent', () => {
  let component: AdminCalendarViewComponent;
  let fixture: ComponentFixture<AdminCalendarViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminCalendarViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminCalendarViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
