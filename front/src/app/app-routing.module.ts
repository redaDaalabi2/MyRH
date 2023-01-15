import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./core/pages/home/home.component";
import {RegisterComponent} from "./core/pages/register/register.component";
import {LoginComponent} from "./core/pages/login/login.component";
import {CompaniesComponent} from "./core/pages/companies/companies.component";
import {ProfileComponent} from "./core/pages/profile/profile.component";
import {OffersComponent} from "./core/pages/offers/offers.component";
import {AuthComponent} from "./admin/pages/auth/auth.component";
import {DashboardComponent} from "./admin/pages/dashboard/dashboard.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'offers', component: OffersComponent },
  { path: 'companies', component: CompaniesComponent },
  { path: 'sign-up', component: RegisterComponent },
  { path: 'sign-in', component: LoginComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'admin/auth', component: AuthComponent },
  { path: 'admin/dashboard', component: DashboardComponent },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
