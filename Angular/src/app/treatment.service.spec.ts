import { TestBed, inject } from '@angular/core/testing';

import { TreatmentService } from './treatment.service';

describe('TreatmentService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TreatmentService]
    });
  });

  it('should be created', inject([TreatmentService], (service: TreatmentService) => {
    expect(service).toBeTruthy();
  }));
});
