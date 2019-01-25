import { TestBed } from '@angular/core/testing';

import { LeaseService } from './lease.service';

describe('LeaseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LeaseService = TestBed.get(LeaseService);
    expect(service).toBeTruthy();
  });
});
