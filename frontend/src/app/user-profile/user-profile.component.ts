import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CurrentUserService } from '../current.user.service';
import { User } from '../User';
import { LogoutService } from '../logout.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
})
export class UserProfileComponent implements OnInit {
  currentUser: User = {
    id: 0,
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    phoneNumber: '',
    email: '',
    age: 0,
    likedRecipe: '',
  };

  public settingUser(newUser: User): void {}

  constructor(
    private router: Router,
    private currentUserService: CurrentUserService,
    private logoutService: LogoutService
  ) {}

  ngOnInit() {
    
    this.getLoggedUser();

  }

  async getLoggedUser() {

    let data = await this.currentUserService.getLoggedUser();
    this.currentUser = data; 
    console.log(this.currentUser);


  }

}
