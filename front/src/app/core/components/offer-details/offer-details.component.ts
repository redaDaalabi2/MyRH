import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Offer} from "../../models/offer";

@Component({
  selector: 'app-offer-details',
  templateUrl: './offer-details.component.html',
  styleUrls: ['./offer-details.component.css']
})
export class OfferDetailsComponent {
  @Input() offer!: Offer
}
