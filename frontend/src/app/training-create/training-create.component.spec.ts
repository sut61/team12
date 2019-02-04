import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainingCreateComponent } from './training-create.component';

describe('TrainingCreateComponent', () => {
  let component: TrainingCreateComponent;
  let fixture: ComponentFixture<TrainingCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrainingCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainingCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
