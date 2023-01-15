import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './core/components/header/header.component';
import { HomeComponent } from './core/pages/home/home.component';
import { RegisterFormComponent } from './core/components/register-form/register-form.component';
import { LoginFormComponent } from './core/components/login-form/login-form.component';
import { LoginComponent } from './core/pages/login/login.component';
import { RegisterComponent } from './core/pages/register/register.component';
import {AppRoutingModule} from "./app-routing.module";
import {BrowserModule} from "@angular/platform-browser";
import { CompaniesComponent } from './core/pages/companies/companies.component';
import {CompanyService} from "./core/services/company.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { CloudinaryModule } from '@cloudinary/angular-5.x';
import {Cloudinary} from 'cloudinary-core';
import { ProfileComponent } from './core/pages/profile/profile.component';
import { LoaderComponent } from './core/components/loader/loader.component';
import { PostComponent } from './core/components/post/post.component';
import { FooterComponent } from './core/components/footer/footer.component';
import { OfferFormComponent } from './core/components/offer-form/offer-form.component';
import { OffersComponent } from './core/pages/offers/offers.component';
import { OfferDetailsComponent } from './core/components/offer-details/offer-details.component';
import { CompanyCardComponent } from './core/components/company-card/company-card.component';
import { AuthComponent } from './admin/pages/auth/auth.component';
import { DashboardComponent } from './admin/pages/dashboard/dashboard.component';
import { CardComponent } from './admin/components/card/card.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    RegisterFormComponent,
    LoginFormComponent,
    LoginComponent,
    RegisterComponent,
    CompaniesComponent,
    ProfileComponent,
    LoaderComponent,
    PostComponent,
    FooterComponent,
    OfferFormComponent,
    OffersComponent,
    OfferDetailsComponent,
    CompanyCardComponent,
    AuthComponent,
    DashboardComponent,
    CardComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    CloudinaryModule.forRoot({Cloudinary}, {
      cloud_name: 'maggie-7223'
    })
  ],
  providers: [CompanyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
