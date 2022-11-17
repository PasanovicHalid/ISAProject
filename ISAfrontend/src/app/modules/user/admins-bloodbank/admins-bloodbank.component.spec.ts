import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminsBloodbankComponent } from './admins-bloodbank.component';

describe('AdminsBloodbankComponent', () => {
  let component: AdminsBloodbankComponent;
  let fixture: ComponentFixture<AdminsBloodbankComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminsBloodbankComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminsBloodbankComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
