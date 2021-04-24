import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTriggerComponent } from './add-trigger.component';

describe('AddTriggerComponent', () => {
  let component: AddTriggerComponent;
  let fixture: ComponentFixture<AddTriggerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddTriggerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTriggerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
