import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaseShowComponent } from './lease-show.component';

describe('LeaseShowComponent', () => {
  let component: LeaseShowComponent;
  let fixture: ComponentFixture<LeaseShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeaseShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaseShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
