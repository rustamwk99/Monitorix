import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAgentTestComponent } from './user-agent-test.component';

describe('UserAgentTestComponent', () => {
  let component: UserAgentTestComponent;
  let fixture: ComponentFixture<UserAgentTestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserAgentTestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserAgentTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
