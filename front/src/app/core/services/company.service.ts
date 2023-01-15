import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../env/environment";
import {Company} from "../models/company";
import {NgForm} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  public getCompanies(): Observable<Company[]>{
    return this.http.get<Company[]>(`${this.apiUrl}/company/all`)
  }

  public addCompany(company: Company): Observable<Company> {
    return this.http.post<Company>(`${this.apiUrl}/register`, company);
  }

  public verificationEmail(codeVer: number): Observable<any>{
    // @ts-ignore
    return this.http.post<any>(`${this.apiUrl}/code-verification?codeParamVer=${codeVer}`, null, { responseType: 'text' });
  }
}
