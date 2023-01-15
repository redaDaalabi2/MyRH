import { Injectable } from '@angular/core';
import {environment} from "../../../env/environment";
import {HttpClient} from "@angular/common/http";
import {AuthCredentials} from "../models/auth-credentials";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class AuthenticationService {
  private apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) {}

  public companyAuth(credentials: AuthCredentials): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/auth/company`, credentials);
  }

  public agentAuth(credentials: AuthCredentials): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/auth/agent`, credentials);
  }

}
