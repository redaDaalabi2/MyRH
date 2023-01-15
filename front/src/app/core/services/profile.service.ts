import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../env/environment";
import {Observable} from "rxjs";
import {Profile} from "../models/profile";

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  apiUrl = environment.apiUrl

  constructor(private http: HttpClient) {}

  public getAllProfiles(): Observable<Profile[]> {
    return this.http.get<Profile[]>(`${this.apiUrl}/profiles`);
  }
}
