import { TestBed } from '@angular/core/testing';

import { HeadAdminService } from './head-admin.service';

describe('HeadAdminService', () => {
  let service: HeadAdminService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HeadAdminService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
