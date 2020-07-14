import { TestBed } from '@angular/core/testing';

import { ListaCnesService } from './lista-cnes.service';

describe('ListaCnesService', () => {
  let service: ListaCnesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListaCnesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
