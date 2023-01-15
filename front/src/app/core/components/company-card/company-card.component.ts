import {Component, Input} from '@angular/core';
import {Company} from "../../models/company";

@Component({
  selector: 'app-company-card',
  templateUrl: './company-card.component.html',
  styleUrls: ['./company-card.component.css']
})
export class CompanyCardComponent {
  @Input() company!: Company;
}
