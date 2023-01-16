import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CONSTANTS } from '../shared/constantes';

// const boundary = "PieBoundary123456789012345678901234567"

// const httpOptions = {
//   headers: new HttpHeaders({  
//     reportProgress: true,
//     responseType: 'json'
//   })
// };
@Injectable({
  providedIn: 'root'
})
export class OffersService {
  
  
  constructor(private http:HttpClient) { }

  saveOffer(offerData: any, files: any){
    console.log(offerData);
    const formData = new FormData();
    formData.append('title', offerData.offer_title);
    formData.append('animal_type', offerData.animal_type);
    formData.append('offer_description', offerData.offer_description);
    formData.append('animal_description', offerData.animal_description);
    formData.append('price', offerData.offer_price);
    formData.append('days', offerData.days_of_adoption);
    formData.append('contact', offerData.contact);
    formData.append('city', offerData.city);
    for(let i = 0; i < files.length; i++){
      formData.append('images', files[i]);
      console.log(files[i]);
    }
    formData.forEach((value, key) => {
      console.log(key + ' ' + value);
    });
    return this.http.post(CONSTANTS.urls.offers, formData, {reportProgress: true, observe: 'events'});
  }

  getOffers(){
    return this.http.get(CONSTANTS.urls.offers);
  }



}
