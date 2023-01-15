import {Component, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {CompanyService} from "../../services/company.service";
import {HttpErrorResponse} from "@angular/common/http";
import {Cloudinary} from "cloudinary-core";
import {Company} from "../../models/company";
import {Router} from "@angular/router";
import {takeUntil} from "rxjs";

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit{
    error = {
      email: '',
      password: '',
      confirmPassword: '',
      emailVerification: ''
    };
    ver = false;
    loader = false;
    publicId = '';

    constructor(private companyService: CompanyService, private router: Router){}

    ngOnInit(): void {}

    register(addCompanyForm: NgForm){
      this.loader = true;
      if(addCompanyForm.value.password != addCompanyForm.value.confirmPassword){
        this.error.confirmPassword = "Password and confirm password doesn't match"
        this.loader = false;
      }else{
        console.log(addCompanyForm.value.imageUrl)
        this.companyService.addCompany(addCompanyForm.value).subscribe(
          (res: Company) => {
            console.log(res);
            this.error.confirmPassword = '';
            addCompanyForm.reset();
            this.loader = false;
            this.ver = true;
          },
          (error: HttpErrorResponse) => {
            console.log(error.message)
            this.loader = false;
          }
        )
      }
    }

    confirmRegistration(code: String){
      this.loader = true;
      console.log("confirm code  " + Number(code));
      this.companyService.verificationEmail(Number(code)).subscribe(
        (res: any) => {
          console.log(res);
          this.loader = false;
          this.router.navigate(['sign-in']).then();
        },
        (error: HttpErrorResponse) => {
          this.loader = false;
          this.error.emailVerification = "The code is invalid, try again!"
          console.log(error.message)
        }
      )
    }

}
