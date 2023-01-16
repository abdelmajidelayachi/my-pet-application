import { Component, OnInit } from '@angular/core';
import { Offer } from 'src/app/interfaces/Offer';
import { OffersService } from 'src/app/services/offers.service';

@Component({
  selector: 'app-offers-posts',
  templateUrl: './offers-posts.component.html',
  styleUrls: ['./offers-posts.component.css']
})
export class OffersPostsComponent implements OnInit {

  offers : Offer[] = [];

  constructor(private offersService : OffersService) { }


  ngOnInit(): void {
    this.offersService.getOffers().subscribe((offers: any) => {
      this.offers = offers.data;
      console.log(this.offers); 
    })
  }

}
