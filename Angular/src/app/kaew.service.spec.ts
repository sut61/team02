import { TestBed, inject } from '@angular/core/testing';

import { KaewService } from './kaew.service';

describe('KaewService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [KaewService]
    });
  });

  it('should be created', inject([KaewService], (service: KaewService) => {
    expect(service).toBeTruthy();
  }));
});
