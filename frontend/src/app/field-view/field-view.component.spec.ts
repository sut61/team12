import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FieldViewComponent } from './field-view.component';

describe('FieldViewComponent', () => {
  let component: FieldViewComponent;
  let fixture: ComponentFixture<FieldViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FieldViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FieldViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
