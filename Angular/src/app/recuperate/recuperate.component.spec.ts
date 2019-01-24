import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecuperateComponent } from './recuperate.component';

describe('RecuperateComponent', () => {
  let component: RecuperateComponent;
  let fixture: ComponentFixture<RecuperateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecuperateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecuperateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
