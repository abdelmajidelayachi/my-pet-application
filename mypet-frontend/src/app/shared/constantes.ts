import { environment } from "src/environments/environment";

export const CONSTANTS = {
  urls:{
    users: `${environment.api_base_url}/users`,
    login: `${environment.api_base_url}/auth/login`,
    register: `${environment.api_base_url}/auth/register`,
  }
}