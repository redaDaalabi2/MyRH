import {Component, OnInit} from '@angular/core';
import {Offer} from "../../models/offer";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {OfferService} from "../../services/offer.service";

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit{
  loader = false;
  offers!: Offer[];
  viewOffer!: Offer;

  constructor(private offerService: OfferService) {}

  ngOnInit() {
    this.fetchAllOffers();
  }

  fetchAllOffers() {
    this.offerService.getAcceptedOffers().subscribe(
      (res: Offer[]) => {
        this.offers = res;
        this.viewOffer = res[0];
      }, (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    )
  }

  viewOfferDetails(offerId: number){
    this.loader = true;
    this.offerService.getOfferById(offerId).subscribe(
      (res: Offer) => {
        this.viewOffer = res;
        this.loader = false;
      }, (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    )
  }
}
