import { TestBed } from '@angular/core/testing';

<<<<<<< HEAD
import { CurrentUserService } from './current.user.service';

describe('CurrentUserService', () => {
  let service: CurrentUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CurrentUserService);
=======
import { Current.UserService } from './current.user.service';

describe('Current.UserService', () => {
  let service: Current.UserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Current.UserService);
>>>>>>> f9d6a518df6efa8114f2e1fd79aa64078380587d
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
