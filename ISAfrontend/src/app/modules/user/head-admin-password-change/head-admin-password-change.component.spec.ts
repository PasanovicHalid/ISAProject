import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeadAdminPasswordChangeComponent } from './head-admin-password-change.component';

describe('HeadAdminPasswordChangeComponent', () => {
  let component: HeadAdminPasswordChangeComponent;
  let fixture: ComponentFixture<HeadAdminPasswordChangeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeadAdminPasswordChangeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HeadAdminPasswordChangeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
