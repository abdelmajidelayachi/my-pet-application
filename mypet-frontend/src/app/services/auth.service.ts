import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CONSTANTS } from '../shared/constantes';
import { BehaviorSubject } from 'rxjs';
import { AuthUser } from '../interfaces/AuthUser';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  authSubject = new BehaviorSubject<AuthUser>({
    token: null,
    isValid: false,
    user: {
      name: '',
      email: ''
    }
  });
  constructor(private http: HttpClient) { }


  registerUser(registerData: any){
    localStorage.clear();
    console.log(registerData);
    return this.http.post(CONSTANTS.urls.register, registerData);
  }
  loginUser(registerData: any){
    localStorage.clear();
    console.log(registerData);
    return this.http.post(CONSTANTS.urls.login, registerData);
  }


  getAuthToken():string {
    if(localStorage.getItem('token')){
      return localStorage.getItem('token') || '';
    }
    return '';
    }
  getAuth(){
    if(localStorage.getItem('token')){
      this.authSubject.next({
        token: localStorage.getItem('token'),
        isValid: true,
        user: {
          name: '',
          email: ''
        }
      });
    }
    return this.authSubject.asObservable();
  }
  setCredentials(token: string) {
    localStorage.setItem('token', token);
    
  }

  logout() {
    // localStorage.removeItem('token');
    // this.authSubject.next({
    //   token: null,
    //   isValid: false,
    //   user: {
    //     name: '',
    //     email: ''
    //   }
    // });
  }


}
