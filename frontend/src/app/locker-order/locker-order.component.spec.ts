import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LockerOrderComponent } from './locker-order.component';

describe('LockerOrderComponent', () => {
  let component: LockerOrderComponent;
  let fixture: ComponentFixture<LockerOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LockerOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LockerOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
