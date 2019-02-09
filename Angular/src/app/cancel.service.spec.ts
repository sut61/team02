import { TestBed, inject } from '@angular/core/testing';

import { CancelService } from './cancel.service';

describe('CancelService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CancelService]
    });
  });

  it('should be created', inject([CancelService], (service: CancelService) => {
    expect(service).toBeTruthy();
  }));
});
