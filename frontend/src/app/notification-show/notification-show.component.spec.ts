import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NotificationShowComponent } from './notification-show.component';

describe('NotificationShowComponent', () => {
  let component: NotificationShowComponent;
  let fixture: ComponentFixture<NotificationShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NotificationShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NotificationShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
