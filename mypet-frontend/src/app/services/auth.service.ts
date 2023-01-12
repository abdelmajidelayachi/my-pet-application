import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CONSTANTS } from '../shared/constantes';

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

  registerUser(registerData: any){
    console.log(registerData);
    return this.http.post(CONSTANTS.urls.register, registerData);
  }
  loginUser(registerData: any){
    console.log(registerData);
    return this.http.post(CONSTANTS.urls.login, registerData);
  }
  

  logUserOut(){
    this.userLoggedIn = false;
  }

  getAuth(){
    return localStorage.getItem('token');
  }


}
