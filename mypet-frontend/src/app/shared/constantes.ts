import { environment } from "src/environments/environment";

export const CONSTANTS = {
  urls:{
    login: `${environment.api_base_url}/auth/login`,
    register: `${environment.api_base_url}/auth/register`,
    offers: `${environment.api_base_url}/posts`,
  }
}