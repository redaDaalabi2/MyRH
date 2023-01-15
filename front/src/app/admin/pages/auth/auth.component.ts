import {Component, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {AuthenticationService} from "../../../core/services/authentication.service";
import {Router} from "@angular/router";
import {HttpErrorResponse} from "@angular/common/http";
import {AuthCredentials} from "../../../core/models/auth-credentials";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit{

  constructor(private authService: AuthenticationService, private router: Router) {}

  ngOnInit() {
    // @ts-ignore
    let auth!: AuthCredentials = JSON.parse(localStorage.getItem("auth"));
    if(auth != null){
      if(auth.role == "AGENT")
        this.router.navigate(['/admin/dashboard']).then();
      else this.router.navigate(['/profile']).then();
    }
  }

  login(credentials: NgForm){
    this.authService.agentAuth(credentials.value).subscribe(
      (res: any) => {
        localStorage.clear();
        localStorage.setItem("auth", JSON.stringify(res));
        this.router.navigate(['admin/dashboard']).then();
      }, (err: HttpErrorResponse) => {
        console.log(err.message);
      }
    )
  }
}
