import {Company} from "./company";
import {Agent} from "./agent";

export interface AuthCredentials {
  login: String,
  password: String,
  token: string,
  company: Company,
  agent: Agent,
  role: String
}
