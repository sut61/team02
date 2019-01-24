import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetinfoComponent } from './petinfo.component';

describe('PetinfoComponent', () => {
  let component: PetinfoComponent;
  let fixture: ComponentFixture<PetinfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetinfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
