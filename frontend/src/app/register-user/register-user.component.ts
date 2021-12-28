import { Component, OnInit } from '@angular/core';
import { User } from '../User';
import { RegistrationService } from '../registration.service';
import { EmailValidator } from '@angular/forms';
import { UserProfileComponent } from '../user-profile/user-profile.component';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css'],
})
export class RegisterUserComponent implements OnInit {
  newUser: User = {
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

  errorMessage!: string; 

  constructor(
    private regService: RegistrationService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  submit(): void {
    

    if(this.newUser.username.length == 0) {

      this.errorMessage = "Please enter a username";
      return; 

    }

    if(this.newUser.password.length == 0) {

      this.errorMessage = "Please enter a password";
      return;

    }

    if(this.newUser.email.length == 0) {

      this.errorMessage = "Please enter an email";
      return;

    }

    this.regService.submit(this.newUser).subscribe((res) => {
      console.log(res);
      this.router.navigate(['login']);

    },
    (err) => {

      this.errorMessage = err.error;
      console.log(err);

    });
  }

  cancel(): void {
    this.router.navigate(['welcome']);
  }
}
