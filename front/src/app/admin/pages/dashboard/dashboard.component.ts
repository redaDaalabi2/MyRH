import {Component, OnInit} from '@angular/core';
import {OfferService} from "../../../core/services/offer.service";
import {Offer} from "../../../core/models/offer";
import {HttpErrorResponse} from "@angular/common/http";
import {AuthCredentials} from "../../../core/models/auth-credentials";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{
  offers!: Offer[]
  countOffers: number[] = [0, 0, 0];
  auth!: AuthCredentials
  constructor(private offerService: OfferService, private router: Router) {}

  ngOnInit(): void {
    // @ts-ignore
    if(JSON.parse(localStorage.getItem("auth")) == null){
      this.router.navigate(['/admin/auth']).then();
    }else{
      // @ts-ignore
      this.auth = JSON.parse(localStorage.getItem("auth"));
      if(this.auth.role == "AGENT")
        this.fetchAllOffers();
      else this.router.navigate(['/profile']).then();
    }
  }

  fetchAllOffers(){
    let pendingCount = 0;
    let acceptedCount = 0;
    this.offerService.getAllOffers(this.auth.token).subscribe(
      (res: Offer[]) => {
        this.offers = res;
        res.forEach(({status}) => {
          if(status == "Pending") {
            pendingCount++;
          }
          if(status == "Accepted") {
            acceptedCount++;
          }
        });
        this.countOffers[0]= res.length;
        this.countOffers[1] = pendingCount;
        this.countOffers[2] = acceptedCount;
      }, (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    )
  }

  acceptOffer(offerId: number){
    this.offerService.acceptOffer(this.auth.token, offerId).subscribe(
      (res: String) => {
        this.ngOnInit();
      }, (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    )
  }

  deleteOffer(offerId: number){
    this.offerService.deleteOffer(this.auth.token, offerId).subscribe(
      (res: String) => {
        this.ngOnInit();
      }, (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    )
  }

  logout(){
    console.log("logout")
    localStorage.clear();
    this.router.navigate(['/admin/auth']).then();
  }

}
