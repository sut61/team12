import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaseOrderComponent } from './lease-order.component';

describe('LeaseOrderComponent', () => {
  let component: LeaseOrderComponent;
  let fixture: ComponentFixture<LeaseOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeaseOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaseOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
