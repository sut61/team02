import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelAppComponent } from './cancel-app.component';

describe('CancelAppComponent', () => {
  let component: CancelAppComponent;
  let fixture: ComponentFixture<CancelAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CancelAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CancelAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
