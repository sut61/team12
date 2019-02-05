import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LockerViewComponent } from './locker-view.component';

describe('LockerViewComponent', () => {
  let component: LockerViewComponent;
  let fixture: ComponentFixture<LockerViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LockerViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LockerViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
