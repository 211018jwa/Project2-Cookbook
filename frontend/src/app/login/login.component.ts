import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { User } from '../User';
import { WelcomeComponent } from '../welcome/welcome.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  username!: string;
  password!: string;

  errorMessage!: string;

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit(): void {}

  checkIfLoggedIn() {
    this.loginService.checkingLoginStatus().subscribe(
      (res) => {
        if (res.status === 200) {
          let body = <User>res.body;
          this.router.navigate(['welcome']);
        }
      },
      (err) => {}
    );
  }
  onButtonClick() {

    console.log(this.username);
    console.log(this.password);

    if(this.username == undefined || this.username.length == 0 ) {

      this.errorMessage = "Please enter a username";
      return;

    }

    if(this.password == undefined || this.password.length == 0 ) {

      this.errorMessage = "Please enter a password";
      return; 

    }



    this.loginService.login(this.username, this.password).subscribe(
      (res) => {
        if (res.status === 200) {
          let body = <User>res.body;

          this.router.navigate(['welcome']);
        }

        
      },
      (err) => {

        this.errorMessage = err.error;
        console.log(err.error);
      }
    );
  }
}
