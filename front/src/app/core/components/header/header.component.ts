import {Component, OnInit} from '@angular/core';
import {AuthCredentials} from "../../models/auth-credentials";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  auth!: AuthCredentials | null;

  constructor(private router: Router) {
  }

  ngOnInit(): void {
    if(localStorage.getItem("auth") == null){
      this.auth = null;
    }else{
      // @ts-ignore
      this.auth = JSON.parse(localStorage.getItem("auth"));
    }
  }

  logout(){
    localStorage.removeItem("auth");
    this.router.navigate(["/sign-in"]).then();
  }

}
