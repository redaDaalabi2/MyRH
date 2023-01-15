import {Component, OnInit} from '@angular/core';
import {Company} from "../../models/company";
import {CompanyService} from "../../services/company.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit{
  public companies: Company[] | undefined

  constructor(private companyService: CompanyService) {}

  ngOnInit() {
    this.getCompanies();
  }

  public getCompanies(): void {
    this.companyService.getCompanies().subscribe(
      (res: Company[]) => {
        this.companies = res;
        console.log(res)
      },
      (error: HttpErrorResponse) => { alert(error.message) }
    )
  }
}
