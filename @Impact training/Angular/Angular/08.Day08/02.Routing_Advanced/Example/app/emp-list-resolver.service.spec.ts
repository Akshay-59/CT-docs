import { TestBed } from '@angular/core/testing';

import { EmpListResolverService } from './emp-list-resolver.service';

describe('EmpListResolverService', () => {
  let service: EmpListResolverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmpListResolverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
