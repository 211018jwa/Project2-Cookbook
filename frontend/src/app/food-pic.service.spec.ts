import { TestBed } from '@angular/core/testing';

import { FoodPicService } from './food-pic.service';

describe('FoodPicService', () => {
  let service: FoodPicService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FoodPicService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
