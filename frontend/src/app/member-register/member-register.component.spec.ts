import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberRegisterComponent } from './member-register.component';

describe('MemberRegisterComponent', () => {
  let component: MemberRegisterComponent;
  let fixture: ComponentFixture<MemberRegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MemberRegisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MemberRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
