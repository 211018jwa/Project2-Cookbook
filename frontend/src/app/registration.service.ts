import { Injectable, Input, Output, EventEmitter } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './User';

@Injectable({
  providedIn: 'root',
})
export class RegistrationService {
  private url: string = 'http://ec2-18-117-174-173.us-east-2.compute.amazonaws.com:8082/users';

  constructor(private httpClient: HttpClient) {}

  submit(newUser: User) {
    console.log(newUser);

    const requestBody = {
      username: newUser.username,
      password: newUser.password,
      firstName: newUser.firstName,
      lastName: newUser.lastName,
      phoneNumber: newUser.phoneNumber,
      email: newUser.email,
      age: newUser.age,
      likedRecipes: newUser.likedRecipe,
    };

    return this.httpClient.post(this.url, requestBody, {
      observe: 'response',
    });
  }
}
