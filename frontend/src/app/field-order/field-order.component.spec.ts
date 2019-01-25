import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FieldOrderComponent } from './field-order.component';

describe('FieldOrderComponent', () => {
  let component: FieldOrderComponent;
  let fixture: ComponentFixture<FieldOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FieldOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FieldOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
