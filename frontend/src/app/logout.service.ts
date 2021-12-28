import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { User } from './User';
import { CurrentUserService } from './current.user.service';

@Injectable({
  providedIn: 'root'
})
export class LogoutService {
  private url: string = 'http://ec2-18-117-174-173.us-east-2.compute.amazonaws.com:8082/logout';

  constructor(
    private httpClient: HttpClient,
    private router: Router,
    private currentUser: CurrentUserService
  ) {}

  logOut() {
    console.log('You are logged out');
    //NOT YET FINISHED - KIND STACK IN HERE
  }
}
