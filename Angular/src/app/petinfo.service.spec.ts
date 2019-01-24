import { TestBed, inject } from '@angular/core/testing';

import { PetinfoService } from './petinfo.service';

describe('PetinfoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PetinfoService]
    });
  });

  it('should be created', inject([PetinfoService], (service: PetinfoService) => {
    expect(service).toBeTruthy();
  }));
});
