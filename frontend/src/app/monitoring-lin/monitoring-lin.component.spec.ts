import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MonitoringLinComponent } from './monitoring-lin.component';

describe('MonitoringLinComponent', () => {
  let component: MonitoringLinComponent;
  let fixture: ComponentFixture<MonitoringLinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MonitoringLinComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MonitoringLinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
