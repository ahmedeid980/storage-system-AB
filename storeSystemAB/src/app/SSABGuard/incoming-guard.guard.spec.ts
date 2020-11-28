import { TestBed } from '@angular/core/testing';

import { IncomingGuardGuard } from './incoming-guard.guard';

describe('IncomingGuardGuard', () => {
  let guard: IncomingGuardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(IncomingGuardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
