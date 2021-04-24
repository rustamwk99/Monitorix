import { TestBed } from '@angular/core/testing';

import { TriggerServiceService } from './trigger-service.service';

describe('TriggerServiceService', () => {
  let service: TriggerServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TriggerServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
