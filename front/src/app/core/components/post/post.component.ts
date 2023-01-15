import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Offer} from "../../models/offer";
import {DatePipe} from "@angular/common";
import {OfferService} from "../../services/offer.service";
import {AuthCredentials} from "../../models/auth-credentials";

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css'],
  providers: [DatePipe]
})
export class PostComponent{
  @Input() auth!: AuthCredentials
  @Input() canDelete!: boolean
  @Input() offer!: Offer
  @Output() viewDetails = new EventEmitter<number>();
  @Output() deleteOffer = new EventEmitter<number>();

  constructor(private datePipe: DatePipe) {}

  setOfferDetails(offerId: number) {
    this.viewDetails.emit(offerId);
  }

  removeOffer(offerId: number){
    this.deleteOffer.emit(offerId);
  }

}
