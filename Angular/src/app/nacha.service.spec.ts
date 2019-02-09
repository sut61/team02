import { TestBed, inject } from '@angular/core/testing';

import { NachaService } from './nacha.service';

describe('NachaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NachaService]
    });
  });

  it('should be created', inject([NachaService], (service: NachaService) => {
    expect(service).toBeTruthy();
  }));
});
