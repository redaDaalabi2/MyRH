import { Component } from '@angular/core';
import {NgForm} from "@angular/forms";
import {AuthenticationService} from "../../services/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})

export class LoginFormComponent {
  loader = false;
  constructor(private authService: AuthenticationService, private router: Router) {}

  login(credentials: NgForm){
    this.loader = true;
    console.log(credentials.value);

    this.authService.companyAuth(credentials.value).subscribe(
      (res: any) => {
        console.log(res);
        localStorage.setItem("auth", JSON.stringify(res));
        this.router.navigate(['profile']).then();
      }, (error) => {
        console.log(error.message());
      }
    );

    setTimeout(function () {
      localStorage.removeItem("auth");
    }, 50000000);

  }
}
