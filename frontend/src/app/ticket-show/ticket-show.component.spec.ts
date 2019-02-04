import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketShowComponent } from './ticket-show.component';

describe('TicketShowComponent', () => {
  let component: TicketShowComponent;
  let fixture: ComponentFixture<TicketShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TicketShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
