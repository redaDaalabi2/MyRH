import {Company} from "./company";
import {Profile} from "./profile";

export interface Offer {
  id: number,
  title: string,
  description: string,
  location: string,
  degree: string,
  salary: number,
  status: string,
  profile: Profile,
  company: Company
  companyId: number,
  profileId: number,
  created: Date
}
