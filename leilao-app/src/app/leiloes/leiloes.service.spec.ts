import { TestBed } from '@angular/core/testing';

import { LeiloesService } from './leiloes.service';

describe('LeiloesService', () => {
  let service: LeiloesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LeiloesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
