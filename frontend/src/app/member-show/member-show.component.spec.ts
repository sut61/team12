import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberShowComponent } from './member-show.component';

describe('MemberShowComponent', () => {
  let component: MemberShowComponent;
  let fixture: ComponentFixture<MemberShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MemberShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MemberShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
