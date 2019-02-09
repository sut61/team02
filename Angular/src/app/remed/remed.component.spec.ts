import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RemedComponent } from './remed.component';

describe('RemedComponent', () => {
  let component: RemedComponent;
  let fixture: ComponentFixture<RemedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RemedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RemedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
