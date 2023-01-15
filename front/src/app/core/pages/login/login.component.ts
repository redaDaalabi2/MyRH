import {Component, OnInit} from '@angular/core';
import {AuthCredentials} from "../../models/auth-credentials";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  auth!: AuthCredentials | null;

  constructor(private router: Router) {
  }

  ngOnInit(): void {
    if(localStorage.getItem("auth") != null){
      this.router.navigate(["/profile"]).then();
    }
  }

}
