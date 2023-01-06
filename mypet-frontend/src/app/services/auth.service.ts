import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  userLoggedIn = false;
  constructor(private http: HttpClient) { }

  isUserLoggedIn(){
    return this.userLoggedIn;
  }

  logUserIn(){
    this.userLoggedIn = true;
  }

  logUserOut(){
    this.userLoggedIn = false;
  }


}
