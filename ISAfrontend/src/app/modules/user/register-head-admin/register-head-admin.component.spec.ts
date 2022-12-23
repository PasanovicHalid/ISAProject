import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterHeadAdminComponent } from './register-head-admin.component';

describe('RegisterHeadAdminComponent', () => {
  let component: RegisterHeadAdminComponent;
  let fixture: ComponentFixture<RegisterHeadAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterHeadAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterHeadAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
