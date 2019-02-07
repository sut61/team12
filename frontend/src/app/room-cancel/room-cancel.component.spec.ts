import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomCancelComponent } from './room-cancel.component';

describe('RoomCancelComponent', () => {
  let component: RoomCancelComponent;
  let fixture: ComponentFixture<RoomCancelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoomCancelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoomCancelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
