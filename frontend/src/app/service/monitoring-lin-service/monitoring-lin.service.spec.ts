import { TestBed } from '@angular/core/testing';

import { MonitoringLinService } from './monitoring-lin.service';

describe('MonitoringLinService', () => {
  let service: MonitoringLinService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MonitoringLinService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
