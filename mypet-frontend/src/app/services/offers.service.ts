import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CONSTANTS } from '../shared/constantes';

@Injectable({
  providedIn: 'root'
})
export class OffersService {
  
  constructor(private http:HttpClient) { }

  saveOffer(offerData: any, files: any){
    return this.http.post(CONSTANTS.urls.offers, offerData,);
  }



}
